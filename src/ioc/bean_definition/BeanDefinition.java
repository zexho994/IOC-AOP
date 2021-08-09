package ioc.bean_definition;

/**
 * 就是Bean，对类进行一层的封装。
 *
 * @author Zexho
 * @date 2021 /7/31 9:31 上午
 */
public interface BeanDefinition {

    int STATUS_UNINITIALIZED = 0;
    int STATUS_INITIALIZED = 1;

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
    Class<?> getBeanClass();

    /**
     * 判断bean是否有初始化
     *
     * @return status == {@link #STATUS_INITIALIZED} ?
     */
    Boolean isInit();

    /**
     * set status to {@link #STATUS_INITIALIZED}
     */
    void setStatusInitialized();

    boolean isAspect();
}
