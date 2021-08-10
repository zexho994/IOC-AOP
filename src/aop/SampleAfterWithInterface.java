package aop;

import ioc.bean_definition.Bean;

@Bean
public class SampleAfterWithInterface implements SampleInterface {

    @Override
    public void print() {
        System.out.println("[原本部分] sample class 1 print after");
    }

}
