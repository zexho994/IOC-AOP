package aop;

import ioc.bean_definition.Bean;

/**
 * @author Zexho
 * @date 2021/8/7 11:19 下午
 */
@Bean
public class SampleBeforeWithInterface implements SampleInterface {

    @Override
    public void print() {
        System.out.println("[原本部分] sample class 1 print before");
    }

}
