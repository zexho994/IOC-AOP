package ioc.bean_definition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * The type Default bean definition.
 *
 * @param <T> the type parameter
 * @author Zexho
 * @date 2021 /7/31 11:21 上午
 */
public class DefaultBeanDefinition<T> implements BeanDefinition {

    private String beanName;
    private final Class<T> beanClass;
    private T beanInstance = null;

    /**
     * Bean status
     */
    private int status = STATUS_UNINITIALIZED;

    /**
     * Instantiates a new Default bean definition.
     *
     * @param name  the name
     * @param clazz the clazz
     */
    public DefaultBeanDefinition(String name, Class<T> clazz) {
        this.beanName = name;
        this.beanClass = clazz;

        createInstance();
    }

    /**
     * 为本Bean创建一个实例，
     */
    @SuppressWarnings("unchecked")
    public void createInstance() {
        Constructor<?>[] declaredConstructors = this.beanClass.getConstructors();
        Constructor<?> noArgsConstructor = declaredConstructors[0];
        noArgsConstructor.setAccessible(true);

        try {
            this.beanInstance = (T) noArgsConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("create new instance error, beanClass =  " + this.beanClass + ", msg = " + e);
        }

    }

    @Override
    public void setName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public String getName() {
        return this.beanName;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setInstance(Object instance) {
        this.beanInstance = (T) instance;
    }

    @Override
    public Object getInstance() {
        return this.beanInstance;
    }

    @Override
    public Class<T> getBeanClass() {
        return this.beanClass;
    }

    @Override
    public Boolean isInit() {
        return this.status == STATUS_INITIALIZED;
    }

    @Override
    public void setStatusInitialized() {
        this.status = STATUS_INITIALIZED;
    }
}
