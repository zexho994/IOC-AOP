package aop;

import aop.cglib_proxy.CglibProxy;
import aop.cglib_proxy.SingleClass;
import aop.jdk_dynamic_proxy.RequestDynamicProxy;
import aop.static_proxy.SubjectProxy;

/**
 * @author Zexho
 * @date 2021/8/4 4:18 下午
 */
public class Application {
    public static void main(String[] args) {
        useCglibProxy();
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
