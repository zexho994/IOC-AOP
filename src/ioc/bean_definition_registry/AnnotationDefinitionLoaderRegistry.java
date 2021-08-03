package ioc.bean_definition_registry;

import utils.Scanner;

import java.util.List;

/**
 * @author Zexho
 * @date 2021/8/2 4:57 下午
 */
public class AnnotationDefinitionLoaderRegistry extends AbstractDefinitionLoaderRegistry {

    @Override
    public void loadBean() {
        List<Class<?>> beans = Scanner.scanBean();
        if (beans.size() == 0) {
            return;
        }

        for (Class<?> bean : beans) {
            this.register(bean.getSimpleName(), bean);
        }
    }

}
