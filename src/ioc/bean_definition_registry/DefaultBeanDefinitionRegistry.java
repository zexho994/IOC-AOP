package ioc.bean_definition_registry;

import exceptions.NoSuchBeanException;
import ioc.bean_definition.BeanDefinition;
import utils.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanDefinitionRegistry简单实现
 * {@code org.springframework.beans.factory.support.DefaultBeanDefinitionRegistry}
 *
 * @author Zexho
 * @date 2021/7/31 10:52 上午
 */
public class DefaultBeanDefinitionRegistry implements BeanDefinitionRegistry {

    /**
     * K: bean name
     * V: bean
     */
    protected final Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<>(64);

    @Override
    public void registerBean(String beanName, BeanDefinition beanDefinition) {
        Assert.hasText(beanName, "beanName's must not be empty");
        Assert.notNull(beanDefinition, "beanDefinition must not be null");
        this.beanMap.put(beanName, beanDefinition);
    }

    @Override
    public void removeBean(String beanName) {
        if (this.beanMap.remove(beanName) == null) {
            throw new NoSuchBeanException(beanName);
        }
    }

    @Override
    public BeanDefinition getBean(String beanName) {
        BeanDefinition bd = this.beanMap.get(beanName);
        if (bd == null) {
            throw new NoSuchBeanException(beanName);
        }
        return bd;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> BeanDefinition getBean(String beanName, Class<T> requiredType) {
        BeanDefinition beanDefinition = this.getBean(beanName);
        if (!beanDefinition.getBeanClass().isAssignableFrom(requiredType))
            throw new NoSuchBeanException(beanName, requiredType);
        return beanDefinition;
    }

}
