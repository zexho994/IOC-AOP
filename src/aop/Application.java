package aop;

import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_definition_registry.AnnotationDefinitionLoaderRegistry;
import ioc.bean_factory.ApplicationContext;

/**
 * @author Zexho
 * @date 2021/8/4 4:18 下午
 */
public class Application {

    private final ApplicationContext factory;

    public Application() {
        // 创建一个注册类,Bean通过注解的方式自动注入
        AbstractDefinitionLoaderRegistry registry = new AnnotationDefinitionLoaderRegistry();
        // 注册类添加到工厂中
        this.factory = new ApplicationContext(registry);
    }

    public static void main(String[] args) {
        Application app = new Application();
        SampleInterface sampleBeforeWithInterface = (SampleInterface) app.factory.getBean("SampleBeforeWithInterface");
        sampleBeforeWithInterface.print();
        SampleInterface sampleAfterWithInterface = (SampleInterface) app.factory.getBean("SampleAfterWithInterface");
        sampleAfterWithInterface.print();
        SampleBeforeNotInterface sampleBeforeNotInterface = (SampleBeforeNotInterface) app.factory.getBean("SampleBeforeNotInterface");
        sampleBeforeNotInterface.print();
    }

}
