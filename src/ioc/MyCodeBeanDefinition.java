package ioc;

import ioc.bean_definition_registry.CodeDefinitionDefinitionLoaderRegistry;

/**
 * @author Zexho
 * @date 2021/8/1 1:36 下午
 */
public class MyCodeBeanDefinition extends CodeDefinitionDefinitionLoaderRegistry {

    @Override
    public void loadBean() {
        System.out.println(" factory => to load bean ");

        // 注册bean
        this.register("BeanTest1", BeanTest1.class);
        this.register("BeanTest2", BeanTest2.class);

        System.out.println(" factory => load bean success");
    }

}
