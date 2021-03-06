package aop.annotations;

import java.lang.annotation.*;

/**
 * @author Zexho
 * @date 2021/8/7 10:17 上午
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Pointcut {

    // 使用beanName定义切点
    String beanName() default "";

}
