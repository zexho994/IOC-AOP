package utils;

import ioc.bean_definition.Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Zexho
 * @date 2021/8/2 6:15 下午
 */
public class Scanner {

    public static List<Class<?>> scanBean() {
        ClassLoader contextClassLoader = getDefaultClassLoader();
        assert contextClassLoader.getResource("") != null : "get contextClassLoader resource fail";
        String path = Objects.requireNonNull(contextClassLoader.getResource("")).getPath();
        List<String> classes = new ArrayList<>();
        scanAddClasses(new File(path), classes);
        List<Class<?>> beans = new ArrayList<>(classes.size());
        for (String c : classes) {
            try {
                Class<?> aClass = contextClassLoader.loadClass(parseFullyQualifiedName(c, path.length()));
                if (isBean(aClass)) {
                    beans.add(aClass);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return beans;
    }

    private static ClassLoader getDefaultClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private static String parseFullyQualifiedName(String classPath, int prefixLen) {
        String s = classPath.substring(prefixLen, classPath.lastIndexOf('.'));
        return s.replace("/", ".");
    }

    private static void scanAddClasses(File file, List<String> beans) {
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isDirectory()) {
                scanAddClasses(f, beans);
            } else {
                beans.add(f.getAbsolutePath());
            }
        }
    }

    private static boolean isBean(Class<?> clazz) {
        Bean[] beanAnnotations = clazz.getDeclaredAnnotationsByType(Bean.class);
        for (Bean beanAnnotation : beanAnnotations) {
            return true;
        }
        return false;
    }

}
