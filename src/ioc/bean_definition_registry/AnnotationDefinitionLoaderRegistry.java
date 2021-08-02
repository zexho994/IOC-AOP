package ioc.bean_definition_registry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zexho
 * @date 2021/8/2 4:57 下午
 */
public class AnnotationDefinitionLoaderRegistry extends AbstractDefinitionLoaderRegistry {

    @Override
    public void loadBean() {
        String property = System.getProperty("user.dir");
        System.out.println("user.dir: " + property);

        String classPath = System.getProperty("java.class.path");
        System.out.println("class path: " + classPath);

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("context path: " + path);

        String curOutPath = this.getClass().getResource("").getPath();
        System.out.println("src path: " + curOutPath);


        File dir = new File("");
        try {
            String canonicalPath = dir.getCanonicalPath();
            System.out.println("cannoicalPath: " + canonicalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 判断类是否有@Bean注解

    }

}
