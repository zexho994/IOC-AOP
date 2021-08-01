package ioc;

import ioc.bean_definition.DefaultBeanDefinition;
import ioc.bean_definition_registry.CustomBeanDefinitionRegistry;

/**
 * @author Zexho
 * @date 2021/8/1 1:36 下午
 */
public class MyBeanDefinition extends CustomBeanDefinitionRegistry {

    @Override
    public void loadBean() {
        System.out.println("factory => load bean");

        this.registerBeanDefinition("BeanTest1", new DefaultBeanDefinition(new BeanTest1()));
        this.registerBeanDefinition("BeanTest2", new DefaultBeanDefinition(new BeanTest1()));
        this.registerBeanDefinition("BeanTest3", new DefaultBeanDefinition(new BeanTest2()));
    }

}
