package ioc;

import exceptions.NoSuchBeanException;
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
    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(64);

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
    public <T> BeanDefinition getBeanDefinition(String beanName, Class<T> requiredType) {
        BeanDefinition beanDefinition = this.getBeanDefinition(beanName);
        if (!beanDefinition.getBeanInstance().getClass().isAssignableFrom(requiredType)) {
            throw new NoSuchBeanException(beanName, requiredType);
        }
        return beanDefinition;
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
