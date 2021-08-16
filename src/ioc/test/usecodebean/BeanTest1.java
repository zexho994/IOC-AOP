package ioc.test.usecodebean;

import ioc.bean_definition.Bean;

/**
 * @author Zexho
 * @date 2021/7/31 10:46 上午
 */
@Bean
public class BeanTest1 implements BeanTest {

    @Override
    public void print() {
        System.out.println("BeanTest1");
    }

}
