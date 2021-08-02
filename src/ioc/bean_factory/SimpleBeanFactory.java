package ioc.bean_factory;

import ioc.bean_definition.BeanDefinition;
import ioc.bean_definition_registry.BeanDefinitionRegistry;

/**
 * @author Zexho
 * @date 2021/7/31 11:18 上午
 */
public class SimpleBeanFactory implements BeanFactory {

    protected final BeanDefinitionRegistry registry;

    public SimpleBeanFactory(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public BeanDefinition getBeanInstance(String beanName) {
        return this.registry.getBean(beanName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBeanInstance(String beanName, Class<T> requiredType) {
        BeanDefinition beanDefinition = this.registry.getBean(beanName, requiredType);
        return (T) beanDefinition.getInstance();
    }
}
