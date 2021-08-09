package aop.sample;

import ioc.bean_definition.Bean;

/**
 * @author Zexho
 * @date 2021/8/7 11:19 下午
 */
@Bean
public class SampleClass implements SampleInterface {
    @Override
    public void printBefore() {
        System.out.println("sample class print before");
    }

    @Override
    public void printAfter() {
        System.out.println("sample class print after");
    }
}
