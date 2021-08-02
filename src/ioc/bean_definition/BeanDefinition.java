package ioc.bean_definition;

/**
 * 就是Bean，对类进行一层的封装。
 *
 * @author Zexho
 * @date 2021 /7/31 9:31 上午
 */
public interface BeanDefinition {

    /**
     * Sets name.
     *
     * @param beanClassName the bean class name
     */
    void setName(String beanClassName);

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Sets instance.
     *
     * @param instance the instance
     */
    void setInstance(Object instance);

    /**
     * Gets instance.
     *
     * @return the instance
     */
    Object getInstance();

    /**
     * Gets bean class.
     *
     * @return bean class
     */
    Class getBeanClass();

}
