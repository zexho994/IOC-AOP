import ioc.BeanTest;
import ioc.BeanTest1;
import ioc.BeanTest2;
import ioc.MyCodeBeanDefinition;
import ioc.bean_definition_registry.AbstractDefinitionLoaderRegistry;
import ioc.bean_definition_registry.AnnotationDefinitionLoaderRegistry;
import ioc.bean_factory.ApplicationContext;

/**
 * @author Zexho
 * @date 2021/7/31 10:44 上午
 */
public class App {

    public static void main(String[] args) {
        // 创建一个注册类,注册类中使用编码实现注册逻辑
        AbstractDefinitionLoaderRegistry registry = new MyCodeBeanDefinition();
        AbstractDefinitionLoaderRegistry registry2 = new AnnotationDefinitionLoaderRegistry();

        // 注册类添加到工厂中
        ApplicationContext factory = new ApplicationContext(registry);
        ApplicationContext factory2 = new ApplicationContext(registry2);

        // 获取类
        BeanTest obj1 = factory.getBeanInstance("BeanTest1", BeanTest1.class);
        obj1.print();
        BeanTest obj2 = factory.getBeanInstance("BeanTest2", BeanTest2.class);
        obj2.print(); // bean test 2

        System.out.printf("obj1 == obj2 ? %s \n", obj1 == obj2);
    }

}
