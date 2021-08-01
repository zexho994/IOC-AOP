package ioc;

/**
 * 就是Bean，对类进行一层的封装。
 *
 * @author Zexho
 * @date 2021/7/31 9:31 上午
 */
public interface BeanDefinition {

    void setBeanClassName(String beanClassName);

    String getBeanClassName();

    void setBeanInstance(Object instance);

    Object getBeanInstance();
}
