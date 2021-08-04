package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Zexho
 * @date 2021/8/4 4:36 下午
 */
public class RequestDynamicProxy implements InvocationHandler {

    private final Object target;

    public RequestDynamicProxy(Object t) {
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy before");
        Object invoke = method.invoke(target, args);
        System.out.println("dynamic proxy after");
        
        return invoke;
    }

}
