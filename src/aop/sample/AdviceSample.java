package aop.sample;

import aop.impl.Aspect;
import aop.impl.Before;
import aop.impl.Pointcut;
import ioc.bean_definition.Bean;

/**
 * @author Zexho
 * @date 2021/8/7 11:27 下午
 */
@Bean
@Aspect
public class AdviceSample {

    @Before
    @Pointcut(beanName = "SampleClass")
    public void enhance() {
        System.out.println("enhance before");
    }

}
