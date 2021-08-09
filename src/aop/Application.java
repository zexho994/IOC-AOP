package aop;

import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_definition_registry.AnnotationDefinitionLoaderRegistry;
import ioc.bean_factory.ApplicationContext;

import java.util.Objects;

/**
 * @author Zexho
 * @date 2021/8/4 4:18 下午
 */
public class Application {
    public static void main(String[] args) {
        // 创建一个注册类,Bean通过注解的方式自动注入
        AbstractDefinitionLoaderRegistry registry = new AnnotationDefinitionLoaderRegistry();
        // 注册类添加到工厂中
        ApplicationContext factory = new ApplicationContext(registry);

        // 使用JDK动态代理
        SampleInterface sample1 = (SampleInterface) factory.getBean("SampleClass1");
        sample1.printBefore();

        SampleClass2 sample2 = (SampleClass2) factory.getBean("SampleClass2");
        sample2.printBefore();
    }
}
