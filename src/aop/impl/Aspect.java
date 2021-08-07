package aop.impl;

import java.lang.annotation.*;

/**
 * 设置为切面
 *
 * @author Zexho
 * @date 2021/8/7 8:41 上午
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Aspect {
}
