package aop;

import aop.annotations.After;
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
    @Pointcut(beanName = "SampleBeforeWithInterface")
    public void enhanceBefore1() {
        System.out.println("[增强部分] 1 before");
    }

    @After
    @Pointcut(beanName = "SampleAfterWithInterface")
    public void enhanceAfter1() {
        System.out.println("[增强部分] 1 after");
    }

    @Before
    @Pointcut(beanName = "SampleBeforeNotInterface")
    public void enhance2Before() {
        System.out.println("[增强部分] 2 before");
    }


}
