package ioc;

/**
 * @author Zexho
 * @date 2021/8/1 1:31 下午
 */
public abstract class CustomBeanDefinitionRegistry extends DefaultBeanDefinitionRegistry implements ResourceLoaderFromCode {

    @Override
    public abstract void loadBean();

}
