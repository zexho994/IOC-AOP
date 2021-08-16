package ioc;

import ioc.bean_definition_registry.CodeDefinitionLoaderRegistry;
import ioc.test.usecodebean.BeanTest1;
import ioc.test.usecodebean.BeanTest2;

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
