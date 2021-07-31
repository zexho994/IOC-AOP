package ioc;

/**
 * bean的调用入口
 *
 * @author Zexho
 * @date 2021/7/31 9:30 上午
 */
public interface BeanFactory {

    Object getBean(String beanName);

    /**
     * 根据名称获取一个bean
     *
     * @param beanName     bean的名称
     * @param requiredType bean类型
     * @return bean名称对应的Bean
     */
    <T> T getBean(String beanName, Class<T> requiredType);
}
