package aop.annotations;

import java.lang.annotation.*;

/**
 * 在方法执行前增强
 *
 * @author Zexho
 * @date 2021/8/7 10:22 上午
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Before {
}
