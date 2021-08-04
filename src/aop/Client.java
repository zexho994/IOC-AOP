package aop;

import java.lang.reflect.Proxy;

/**
 * @author Zexho
 * @date 2021/8/4 4:18 下午
 */
public class Client {
    public static void main(String[] args) {
        useDynamicProxy();
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
        ISubject subjectProxy = (ISubject) Proxy.newProxyInstance(
                SubjectImpl.class.getClassLoader(),
                SubjectImpl.class.getInterfaces(),
                new RequestDynamicProxy(new SubjectImpl()));
        subjectProxy.request();

        IRequest requestProxy = (IRequest) Proxy.newProxyInstance(
                RequestImpl.class.getClassLoader(),
                RequestImpl.class.getInterfaces(),
                new RequestDynamicProxy(new RequestImpl()));
        requestProxy.request();
    }
}
