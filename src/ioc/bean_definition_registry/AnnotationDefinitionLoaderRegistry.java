package ioc.bean_definition_registry;

import aop.cglib_proxy.CglibProxy;
import aop.annotations.After;
import aop.annotations.Before;
import aop.annotations.Pointcut;
import aop.jdk_dynamic_proxy.JDKDynamicProxy;
import exceptions.NotFoundAspectAdvice;
import ioc.bean_definition.BeanDefinition;
import ioc.bean_definition.DefaultBeanDefinition;
import utils.BeanScanner;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Zexho
 * @date 2021/8/2 4:57 下午
 */
public class AnnotationDefinitionLoaderRegistry extends AbstractDefinitionLoaderRegistry {

    @Override
    public void loadBean() {
        BeanScanner.findAllBean().forEach(bean -> AnnotationDefinitionLoaderRegistry.this.register(bean.getSimpleName(), bean));
        this.loadAspect();
    }

    private void loadAspect() {
        List<BeanDefinition> aspectList = this.beanMap.values().stream().filter(BeanDefinition::isAspect).collect(Collectors.toList());
        aspectList.forEach(this::execAdvice);
    }

    private void execAdvice(BeanDefinition bean) {
        for (Method method : bean.getBeanClass().getMethods()) {
            Pointcut[] pointcuts = method.getDeclaredAnnotationsByType(Pointcut.class);
            if (pointcuts.length == 0) {
                continue;
            }
            BeanDefinition targetBean = this.getBean(pointcuts[0].beanName());
            AnnotatedType[] annotatedInterfaces = targetBean.getBeanClass().getAnnotatedInterfaces();
            Object proxy;
            if (method.getDeclaredAnnotationsByType(Before.class).length > 0) {
                if (annotatedInterfaces.length > 0) {
                    proxy = new JDKDynamicProxy().getDynamicProxyImpl(targetBean.getInstance(), method, bean.getInstance(), null, null);
                } else {
                    proxy = CglibProxy.getProxy(targetBean.getInstance(), method, bean.getInstance(), null, null);
                }
                BeanDefinition beanDefinition = new DefaultBeanDefinition<>(targetBean.getName(), targetBean.getBeanClass(), proxy);
                registerBean(targetBean.getName(), beanDefinition);
            } else if (method.getDeclaredAnnotationsByType(After.class).length > 0) {
                if (annotatedInterfaces.length > 0) {
                    proxy = new JDKDynamicProxy().getDynamicProxyImpl(targetBean.getInstance(), null, null, method, bean.getInstance());
                } else {
                    proxy = CglibProxy.getProxy(targetBean.getInstance(), null, null, method, bean.getInstance());
                }
                BeanDefinition beanDefinition = new DefaultBeanDefinition<>(targetBean.getName(), targetBean.getBeanClass(), proxy);
                registerBean(targetBean.getName(), beanDefinition);

            } else {
                throw new NotFoundAspectAdvice(targetBean.getName());
            }
        }
    }

}
