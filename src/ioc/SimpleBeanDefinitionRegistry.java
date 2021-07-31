package ioc;

import exceptions.NoSuchBeanException;
import utils.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanDefinitionRegistry简单实现
 * {@code org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry}
 *
 * @author Zexho
 * @date 2021/7/31 10:52 上午
 */
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry {

    /**
     * K: bean name
     * V: bean
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        Assert.hasText(beanName, "beanName's must not be empty");
        Assert.notNull(beanDefinition, "beanDefinition must not be null");
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) {
        if (this.beanDefinitionMap.remove(beanName) == null) {
            throw new NoSuchBeanException(beanName);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition bd = this.beanDefinitionMap.get(beanName);
        if (bd == null) {
            throw new NoSuchBeanException(beanName);
        }
        return bd;
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName, Class requiredType) {
        BeanDefinition beanDefinition = this.getBeanDefinition(beanName);
        if (!beanDefinition.getBeanClass().isInstance(requiredType)) {
            throw new NoSuchBeanException(beanName, requiredType);
        }
        return null;
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return this.beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }

    @Override
    public boolean isBeanNameInUse(String beanName) {
        throw new RuntimeException("todo");
    }
}
