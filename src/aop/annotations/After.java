package aop.annotations;

import java.lang.annotation.*;

/**
 * @author Zexho
 * @date 2021/8/9 6:51 下午
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface After {
}
