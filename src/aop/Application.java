package aop;

import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_definition_registry.AnnotationDefinitionLoaderRegistry;
import ioc.bean_factory.ApplicationContext;

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
        SampleInterface sampleBefore1 = (SampleInterface) factory.getBean("SampleBeforeWithInterface");
        sampleBefore1.print();
        SampleInterface sampleAfter1 = (SampleInterface) factory.getBean("SampleAfterWithInterface");
        sampleAfter1.print();

        SampleBeforeNotInterface sample2 = (SampleBeforeNotInterface) factory.getBean("SampleBeforeNotInterface");
        sample2.print();
    }
}
