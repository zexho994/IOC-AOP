package ioc.bean_resource_loader;

/**
 * 以代码的方式进行注册
 *
 * @author Zexho
 * @date 2021/8/1 1:29 下午
 */
public interface ResourceLoaderFromCode extends ResourceLoader {

    /**
     * {@link ResourceLoader#loadBean()}
     */
    @Override
    void loadBean();

}
