package aop.impl;

import java.lang.annotation.*;

/**
 * @author Zexho
 * @date 2021/8/8 10:16 下午
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AdviceRule {
}
