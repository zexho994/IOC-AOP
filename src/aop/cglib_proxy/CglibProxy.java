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

    private Method before = null;
    private Object beforeObj = null;

    private Method after = null;
    private Object afterObj = null;

    /**
     * @param obj         cglib动态代理生成的实例
     * @param method      被调用的方法的引用
     * @param params      参数列表
     * @param methodProxy 代理类对方法的代理引用
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        if (before != null) {
            before.invoke(beforeObj);
        }
        Object result = methodProxy.invokeSuper(obj, params);
        if (after != null) {
            after.invoke(afterObj);
        }
        return result;
    }

    public void setBefore(Method before, Object beforeObj) {
        this.before = before;
        this.beforeObj = beforeObj;
    }

    public void setAfter(Method after, Object afterObj) {
        this.after = after;
        this.afterObj = afterObj;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(T target, Method before, Object beforeObj, Method after, Object afterObj) {
        ENHANCER.setSuperclass(target.getClass());
        CglibProxy cglibProxy = new CglibProxy();
        cglibProxy.setBefore(before, beforeObj);
        cglibProxy.setAfter(after, afterObj);

        ENHANCER.setCallback(cglibProxy);
        return (T) ENHANCER.create();
    }

}
