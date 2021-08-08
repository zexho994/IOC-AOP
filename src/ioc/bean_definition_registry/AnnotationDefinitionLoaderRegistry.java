package ioc.bean_definition_registry;

import aop.impl.Before;
import aop.impl.Pointcut;
import exceptions.NotFoundAspectAdvice;
import ioc.bean_definition.BeanDefinition;
import utils.BeanScanner;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.List;
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
            AnnotatedType[] annotatedInterfaces = bean.getBeanClass().getAnnotatedInterfaces();
            if (method.getDeclaredAnnotationsByType(Before.class).length > 0) {
                System.out.printf("annotated interfaces count = %s, advice = %s\n", annotatedInterfaces.length, Before.class);
            } else {
                throw new NotFoundAspectAdvice(targetBean.getName());
            }

        }
    }
}
