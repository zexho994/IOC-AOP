package ioc.bean_definition_registry;

import ioc.bean_definition.BeanDefinition;

/**
 * bean的存储
 *
 * @author Zexho
 * @date 2021/7/31 9:30 上午
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册一个新的Bean
     *
     * @param beanName       bean的注册使用名称
     * @param beanDefinition bean的类型
     */
    void registerBean(String beanName, BeanDefinition beanDefinition);

    /**
     * 移除一个Bean
     *
     * @param beanName 要移除的Bean的名称
     */
    void removeBean(String beanName);

    /**
     * 根据名称获取Bean
     *
     * @param beanName bean名称
     * @return 已注册的 {@link BeanDefinition} 对象
     */
    BeanDefinition getBean(String beanName);

    /**
     * 获取Bean
     * {@link BeanDefinition}
     *
     * @param beanName     bean名称
     * @param requiredType bean类型，会进行校验
     * @return 已注册的 {@link BeanDefinition} 对象
     */
    <T> BeanDefinition getBean(String beanName, Class<T> requiredType);

}
