package ioc;

/**
 * @author Zexho
 * @date 2021/7/31 1:11 下午
 */
public abstract class ApplicationContext extends SimpleBeanFactory implements ResourceLoader {

    public ApplicationContext(BeanDefinitionRegistry registry) {
        super(registry);
    }

}
