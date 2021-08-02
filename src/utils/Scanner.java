package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Zexho
 * @date 2021/8/2 6:15 下午
 */
public class Scanner {

    public static List<String> scanBean() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        int pathLen = path.length();

        List<String> beans = new ArrayList<>();
        scan(new File(path), beans);

        for (String bean : beans) {
            String sub = bean.substring(pathLen, bean.lastIndexOf('.'));
            String b = sub.replace("/", ".");
            try {
                Class<?> aClass = Class.forName(b);
                System.out.println("new class = " + aClass.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return beans;
    }

    public static void scan(File file, List<String> beans) {
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isDirectory()) {
                scan(f, beans);
            } else {
                beans.add(f.getAbsolutePath());
            }
        }
    }


    public static void main(String[] args) {
        Scanner.scanBean();
    }
}
