package aop.sample;

import aop.impl.Pointcut;
import ioc.bean_definition.Bean;

/**
 * 定义切入点
 *
 * @author Zexho
 * @date 2021/8/7 10:53 上午
 */
@Bean
public class PointcutSample {

    @Pointcut(beanName = "SampleClass")
    public void toSampleClass() {
    }

}
