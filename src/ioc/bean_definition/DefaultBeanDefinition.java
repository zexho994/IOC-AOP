package ioc.bean_definition;

import ioc.bean_definition.BeanDefinition;

/**
 * @author Zexho
 * @date 2021/7/31 11:21 上午
 */
public class DefaultBeanDefinition implements BeanDefinition {

    private String beanDefinitionName;
    private Object beanDefinitionInstance;

    public DefaultBeanDefinition(Object obj) {
        this.beanDefinitionInstance = obj;
    }

    @Override
    public void setBeanClassName(String beanName) {
        this.beanDefinitionName = beanName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanDefinitionName;
    }

    @Override
    public void setBeanInstance(Object instance) {
        this.beanDefinitionInstance = instance;
    }

    @Override
    public Object getBeanInstance() {
        return this.beanDefinitionInstance;
    }

}
