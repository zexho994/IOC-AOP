package aop.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * @author Zexho
 * @date 2021/8/4 4:36 下午
 */
public class RequestDynamicProxy implements InvocationHandler {

    private Object target = null;

    /**
     * @param proxy  代理的真实对象
     * @param method 要调用的真实对象的方法
     * @param args   方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy before");
        Object invoke = method.invoke(target, args);
        System.out.println("dynamic proxy after");

        return invoke;
    }

    /**
     * 获取动态代理对象
     *
     * @param obj 被代理类
     * @return obj的父接口实现子类, 因为返回的是T父接口重写的类
     */
    @SuppressWarnings("unchecked")
    public <T> T getDynamicProxyImpl(T obj) {
        assert obj != null;
        target = obj;

        // newProxyInstance() 会创建类$A，$A实现了obj的父接口，所有接口方法内容都为 {@link #invoke()} 。
        return (T) newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}
