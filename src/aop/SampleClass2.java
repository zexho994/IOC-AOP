package aop;

import ioc.bean_definition.Bean;

@Bean
public class SampleClass2 {

    public void printBefore() {
        System.out.println("[原本部分] sample class 2 print before");
    }

    public void printAfter() {
        System.out.println("[原本部分] sample class 2 print after");
    }

}
