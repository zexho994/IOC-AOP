package ioc;

import ioc.bean_definition.Bean;
import ioc.bean_definition_registry.Autowired;

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

