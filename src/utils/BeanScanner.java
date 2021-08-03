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
public class BeanScanner {

    public static List<Class<?>> findAllBean() {
        ClassLoader contextClassLoader = getDefaultClassLoader();
        List<String> classes = scanClasses(contextClassLoader);
        return filtersAndLoadBeans(classes, contextClassLoader);
    }

    private static List<Class<?>> filtersAndLoadBeans(List<String> classes, ClassLoader contextClassLoader) {
        List<Class<?>> beans = new ArrayList<>(classes.size());
        String path = Objects.requireNonNull(contextClassLoader.getResource("")).getPath();

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

    private static List<String> scanClasses(ClassLoader contextClassLoader) {
        List<String> classes = new ArrayList<>();
        String path = Objects.requireNonNull(contextClassLoader.getResource("")).getPath();

        scanAddClasses(new File(path), classes);

        return classes;
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
        return clazz.getDeclaredAnnotationsByType(Bean.class).length > 0;
    }

}
