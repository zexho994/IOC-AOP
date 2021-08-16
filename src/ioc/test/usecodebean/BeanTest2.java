package ioc.test.usecodebean;

import ioc.bean_definition.Bean;

/**
 * @author Zexho
 * @date 2021/8/1 2:34 下午
 */
@Bean
public class BeanTest2 implements BeanTest {

    @Override
    public void print() {
        System.out.println("BeanTest2");
    }

}
