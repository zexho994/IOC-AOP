package ioc.bean_definition_registry;

import ioc.bean_definition.BeanDefinition;
import ioc.bean_definition.DefaultBeanDefinition;
import ioc.bean_resource_loader.ResourceLoader;

/**
 * @author Zexho
 * @date 2021/8/1 1:31 下午
 */
public abstract class AbstractDefinitionLoaderRegistry extends DefaultBeanDefinitionRegistry implements ResourceLoader {

    @Override
    public abstract void loadBean();

    @SuppressWarnings("unchecked")
    public <T> void register(String beanName, Class<T> clazz) {
        BeanDefinition definition = new DefaultBeanDefinition(beanName, clazz);
        this.beanMap.put(beanName, definition);
    }

}
