package ioc;

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
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    void removeBeanDefinition(String beanName);

    BeanDefinition getBeanDefinition(String beanName);

    BeanDefinition getBeanDefinition(String beanName, Class requiredType);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();

    int getBeanDefinitionCount();

    boolean isBeanNameInUse(String beanName);

}
