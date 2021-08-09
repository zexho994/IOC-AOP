package aop.sample;

import ioc.bean_definition.Bean;

@Bean
public class SampleClass2 {

    public void printBefore() {
        System.out.println("sample class 2 print before");
    }

    public void printAfter() {
        System.out.println("sample class 2 print after");
    }

}
