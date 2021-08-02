package ioc.bean_definition_registry;

import java.lang.annotation.*;

/**
 * @author Zexho
 * @date 2021/8/2 9:22 上午
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

}
