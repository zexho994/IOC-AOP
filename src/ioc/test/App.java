package ioc.test;

import ioc.*;

/**
 * @author Zexho
 * @date 2021/7/31 10:44 上午
 */
public class App {

    public static void main(String[] args) {
        // 创建一个注册类,注册类中实现注册逻辑
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

        // 注册类添加到工厂中
        ApplicationContext factory = new ApplicationContext(registry) {
            @Override
            public void loadBean() {
                System.out.println("factory => load bean");
                BeanDefinition bean1 = new SimpleBeanDefinition(BeanTest1.class);
                this.registry.registerBeanDefinition("BeanTest1", bean1);
            }
        };

        factory.loadBean();

        BeanTest bean1 = factory.getBean("BeanTest1", BeanTest.class);
        bean1.print(); // bean test 1
//
//        BeanTest bean2 = factory.getBean("BeanTest2", BeanTest.class);
//        bean2.print(); // bean test 2
    }

}
