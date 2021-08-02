package ioc.bean_definition;

import java.lang.annotation.*;

/**
 * @author Zexho
 * @date 2021/8/2 9:20 上午
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {

}
