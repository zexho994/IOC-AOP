package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zexho
 * @date 2021/8/2 6:15 下午
 */
public class Scanner {

    public static List<String> scanBean() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        ClassLoader classLoader = Scanner.class.getClassLoader();

        File root = new File(path);
        List<String> beans = new ArrayList<>();

        scan(root, beans, classLoader);

        return beans;
    }

    public static void scan(File file, List<String> beans, ClassLoader classLoader) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                scan(f, beans, classLoader);
            } else {
                beans.add(f.getAbsolutePath());
            }
        }
    }


    public static void main(String[] args) {
        Scanner.scanBean();
    }
}
