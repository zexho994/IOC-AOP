package ioc.bean_definition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Zexho
 * @date 2021/7/31 11:21 上午
 */
public class DefaultBeanDefinition<T> implements BeanDefinition {

    private String beanName;
    private final Class<T> beanClass;
    private T beanInstance = null;

    public DefaultBeanDefinition(String name, Class<T> clazz) {
        this.beanName = name;
        this.beanClass = clazz;

        // new instance
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
            Object instance = noArgsConstructor.newInstance(beanInstance);
            this.beanInstance = (T) noArgsConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
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

}
