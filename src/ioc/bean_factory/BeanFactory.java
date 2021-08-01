package ioc.bean_factory;

import ioc.bean_definition.BeanDefinition;

/**
 * bean的调用入口
 *
 * @author Zexho
 * @date 2021/7/31 9:30 上午
 */
public interface BeanFactory {

    /**
     * 根据名称获取bean
     *
     * @param beanName bean名称
     * @return bean名称对应的Bean
     */
    BeanDefinition getBeanInstance(String beanName);

    /**
     * 根据名称获取一个bean
     *
     * @param beanName     bean的名称
     * @param requiredType bean类型
     * @return bean名称对应的Bean
     */
    <T> T getBeanInstance(String beanName, Class<T> requiredType);
}
