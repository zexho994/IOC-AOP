package ioc;

/**
 * bean的调用入口
 *
 * @author Zexho
 * @date 2021/7/31 9:30 上午
 */
public interface BeanFactory<T extends BeanDefinition> {

    /**
     * 根据名称获取一个bean
     *
     * @param beanName bean的名称
     * @return bean名称对应的Bean
     */
    T getBean(String beanName);
}
