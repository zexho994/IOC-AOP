package ioc;

/**
 * @author Zexho
 * @date 2021/7/31 11:18 上午
 */
public class SimpleBeanFactory implements BeanFactory {

    private final BeanDefinitionRegistry registry;

    public SimpleBeanFactory(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
        return beanDefinition.getBeanClass();
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return (T) registry.getBeanDefinition(beanName, requiredType);
    }
}
