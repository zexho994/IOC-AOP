package aop.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Zexho
 * @date 2021/8/5 6:54 下午
 */
public class CglibProxy implements MethodInterceptor {

    public static final Enhancer ENHANCER = new Enhancer();

    /**
     * @param obj         cglib动态代理生成的实例
     * @param method      被调用的方法的引用
     * @param params      参数列表
     * @param methodProxy 代理类对方法的代理引用
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(obj, params);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(T target) {
        ENHANCER.setSuperclass(target.getClass());
        ENHANCER.setCallback(new CglibProxy());
        return (T) ENHANCER.create();
    }

}
