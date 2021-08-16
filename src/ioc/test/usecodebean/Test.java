package ioc.test.usecodebean;

import ioc.MyCodeBeanDefinition;
import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_factory.ApplicationContext;

/**
 * @author Zexho
 * @date 2021/8/16 6:40 下午
 */
public class Test {

    public static void main(String[] args) {
        Test.useCodeBeanDefinition();
    }

    public static void useCodeBeanDefinition() {
        // 创建一个注册类,注册类中使用编码实现注册逻辑
        AbstractDefinitionLoaderRegistry registry = new MyCodeBeanDefinition();
        // 注册类添加到工厂中
        ApplicationContext factory = new ApplicationContext(registry);

        // 获取类
        BeanTest obj1 = factory.getBeanInstance("BeanTest1", BeanTest1.class);
        obj1.print();
        BeanTest obj2 = factory.getBeanInstance("BeanTest2", BeanTest2.class);
        obj2.print();
    }
}
