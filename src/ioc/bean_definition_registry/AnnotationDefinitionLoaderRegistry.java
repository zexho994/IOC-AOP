package ioc.bean_definition_registry;

import utils.Scanner;

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
        List<Class<?>> classes = Scanner.scanBean();
        if (classes.size() == 0) {
            return;
        }
        ;
    }

}
