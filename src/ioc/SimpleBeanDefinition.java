package ioc;

/**
 * @author Zexho
 * @date 2021/7/31 11:21 上午
 */
public class SimpleBeanDefinition implements BeanDefinition {

    private String beanDefinitionName;
    private Class<?> beanDefinitionClass;

    public SimpleBeanDefinition(Class<?> beanClass) {
        this.beanDefinitionClass = beanClass;
    }


    @Override
    public void setBeanClassName(String beanName) {
        this.beanDefinitionName = beanName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanDefinitionName;
    }

    @Override
    public void setBeanClass(Class beanClass) {
        this.beanDefinitionClass = beanClass;
    }

    @Override
    public Class getBeanClass() {
        return this.beanDefinitionClass;
    }

}
