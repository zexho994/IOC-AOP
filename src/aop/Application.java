package aop;

import aop.cglib_proxy.CglibProxy;
import aop.cglib_proxy.SingleClass;
import aop.jdk_dynamic_proxy.RequestDynamicProxy;
import aop.sample.SampleClass;
import aop.static_proxy.SubjectProxy;
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

        // 测试自动装载@Autowired
        SampleClass sample = (SampleClass) factory.getBean("SampleClass");
        sample.print();
    }

    /**
     * 使用静态代理，代理ISubject
     */
    public void useStaticProxy() {
        ISubject subject = new SubjectImpl();
        ISubject subjectProxy = new SubjectProxy(subject);

        subjectProxy.request();
    }

    /**
     * 使用JDK静态代理
     */
    public static void useDynamicProxy() {
        // 动态代理构造类
        RequestDynamicProxy proxy = new RequestDynamicProxy();

        // 获取ISubject的代理类
        ISubject subjectProxy = proxy.getDynamicProxyImpl(new SubjectImpl());
        subjectProxy.request();

        // 获取IRequest的代理类
        IRequest requestProxy = proxy.getDynamicProxyImpl(new RequestImpl());
        requestProxy.request();
    }

    public static void useCglibProxy() {
        SingleClass enhancer = CglibProxy.getProxy(new SingleClass());
        enhancer.print1();
        enhancer.print2();
    }
}
