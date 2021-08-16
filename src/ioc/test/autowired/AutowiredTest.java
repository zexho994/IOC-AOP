package ioc.test.autowired;

import ioc.bean_definition.Bean;
import ioc.bean_definition_registry.Autowired;
import ioc.test.usecodebean.BeanTest1;
import ioc.test.usecodebean.BeanTest2;

/**
 * 自动注入测试类
 *
 * @author zexho
 */
@Bean
public class AutowiredTest {

    @Autowired
    public BeanTest1 beanTest1;
    @Autowired
    public BeanTest2 beanTest2;

    public void print1() {
        beanTest1.print();
    }

    public void print2() {
        beanTest2.print();
    }

}

