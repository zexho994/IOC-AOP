package aop;

import aop.annotations.Aspect;
import aop.annotations.Before;
import aop.annotations.Pointcut;
import ioc.bean_definition.Bean;

/**
 * @author Zexho
 * @date 2021/8/7 11:27 下午
 */
@Bean
@Aspect
public class AdviceSample {

    @Before
    @Pointcut(beanName = "SampleClass1")
    public void enhance1() {
        System.out.println("[增强部分] 1 before");
    }

    @Before
    @Pointcut(beanName = "SampleClass2")
    public void enhance2() {
        System.out.println("[增强部分] 2 before");
    }

}
