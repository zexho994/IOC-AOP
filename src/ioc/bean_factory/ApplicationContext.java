package ioc.bean_factory;

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

    private void initBean(BeanDefinition beanDefinition) throws IllegalAccessException {
        Object instance = beanDefinition.getInstance();

        for (Field field : instance.getClass().getFields()) {
            if (field.getDeclaredAnnotationsByType(Autowired.class).length > 0) {
                Class<?> fieldType = field.getType();
                Object bean = this.getBean(fieldType.getSimpleName());
                field.set(instance, bean);
            }
        }

        beanDefinition.setStatusInitialized();
    }

}
