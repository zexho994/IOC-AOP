package ioc;

import ioc.bean_definition.Bean;
import ioc.bean_definition_registry.Autowired;

@Bean
public class AutowiredTest {

    @Autowired
    BeanTest1 beanTest1;

    public void print() {
        beanTest1.print();
    }

}
