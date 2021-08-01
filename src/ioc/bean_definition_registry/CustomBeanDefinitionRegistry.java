package ioc.bean_definition_registry;

import ioc.bean_resource_loader.ResourceLoaderFromCode;

/**
 * @author Zexho
 * @date 2021/8/1 1:31 下午
 */
public abstract class CustomBeanDefinitionRegistry extends DefaultBeanDefinitionRegistry implements ResourceLoaderFromCode {

    @Override
    public abstract void loadBean();

}
