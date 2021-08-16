package ioc.test.circular_dependencies;

import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_definition_registry.AnnotationDefinitionLoaderRegistry;
import ioc.bean_factory.ApplicationContext;

/**
 * @author Zexho
 * @date 2021/8/16 5:41 下午
 */
public class Test {

    public static void main(String[] args) {
        Test.useAnnotationBeanDefinition();
    }

    public static void useAnnotationBeanDefinition() {
        AbstractDefinitionLoaderRegistry registry = new AnnotationDefinitionLoaderRegistry();
        ApplicationContext factory = new ApplicationContext(registry);

        ClassA classA = (ClassA) factory.getBean("ClassA");
        ClassB classB = (ClassB) factory.getBean("ClassB");
        classA.printB();
        classB.printA();
    }
}
