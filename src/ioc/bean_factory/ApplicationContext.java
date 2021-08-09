package ioc.bean_factory;

import aop.annotations.Aspect;
import ioc.bean_definition.BeanDefinition;
import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_definition_registry.Autowired;

import java.lang.reflect.Field;

/**
 * @author Zexho
 * @date 2021/7/31 1:11 下午
 */
public class ApplicationContext extends SimpleBeanFactory {

    public ApplicationContext(AbstractDefinitionLoaderRegistry registry) {
        super(registry);
        registry.loadBean();
    }

    /**
     * 获取Bean
     */
    public Object getBean(String beanName) {
        BeanDefinition bean = this.getBeanInstance(beanName);
        if (!bean.isInit()) {
            try {
                this.initBean(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return bean.getInstance();
    }

    /**
     * 初始化Bean
     */
    private void initBean(BeanDefinition beanDefinition) throws IllegalAccessException {
        Object instance = beanDefinition.getInstance();

        this.initAutowire(instance);
        this.initAspect(instance);

        beanDefinition.setStatusInitialized();
    }

    /**
     * 设置bean里面的注入字段
     */
    private void initAutowire(Object instance) throws IllegalAccessException {
        for (Field field : instance.getClass().getFields()) {
            if (field.getDeclaredAnnotationsByType(Autowired.class).length == 0) {
                continue;
            }
            Class<?> fieldType = field.getType();
            Object bean = this.getBean(fieldType.getSimpleName());
            field.set(instance, bean);
        }

    }

    private void initAspect(Object instance) {
        Aspect[] aspects = instance.getClass().getDeclaredAnnotationsByType(Aspect.class);
        if (aspects.length == 0) {
            return;
        }
        Aspect aspect = aspects[0];
    }

}
