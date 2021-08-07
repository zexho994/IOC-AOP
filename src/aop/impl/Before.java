package aop.impl;

import java.lang.annotation.*;

/**
 * @author Zexho
 * @date 2021/8/7 10:22 上午
 */

@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Before {

}
