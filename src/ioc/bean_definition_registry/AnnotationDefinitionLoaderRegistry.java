package ioc.bean_definition_registry;

import utils.BeanScanner;

/**
 * @author Zexho
 * @date 2021/8/2 4:57 下午
 */
public class AnnotationDefinitionLoaderRegistry extends AbstractDefinitionLoaderRegistry {

    @Override
    public void loadBean() {
        BeanScanner.findAllBean().forEach(bean -> AnnotationDefinitionLoaderRegistry.this.register(bean.getSimpleName(), bean));
    }

}
