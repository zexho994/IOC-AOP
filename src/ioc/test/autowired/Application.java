package ioc.test.autowired;

import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_definition_registry.AnnotationDefinitionLoaderRegistry;
import ioc.bean_factory.ApplicationContext;

/**
 * @author Zexho
 * @date 2021/7/31 10:44 上午
 */
public class Application {

    public static void main(String[] args) {
        useAnnotationBeanDefinition();
    }

    public static void useAnnotationBeanDefinition() {
        // 创建一个注册类,Bean通过注解的方式自动注入
        AbstractDefinitionLoaderRegistry registry = new AnnotationDefinitionLoaderRegistry();
        // 注册类添加到工厂中
        ApplicationContext factory = new ApplicationContext(registry);

        // 测试自动装载@Autowired
        AutowiredTest at = (AutowiredTest) factory.getBean("AutowiredTest");
        at.print1();
        at.print2();
    }

}
