package aop;

import ioc.bean_definition.Bean;

@Bean
public class SampleBeforeNotInterface {

    public void print() {
        System.out.println("[原本部分] sample class 2 print before");
    }

}
