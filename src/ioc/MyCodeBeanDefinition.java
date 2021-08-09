package ioc;

import ioc.bean_definition_registry.CodeDefinitionLoaderRegistry;

/**
 * @author Zexho
 * @date 2021/8/1 1:36 下午
 */
public class MyCodeBeanDefinition extends CodeDefinitionLoaderRegistry {

    @Override
    public void loadBean() {
        this.register("BeanTest1", BeanTest1.class);
        this.register("BeanTest2", BeanTest2.class);
    }

}
