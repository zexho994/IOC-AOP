package ioc.bean_definition_registry;

/**
 * @author Zexho
 * @date 2021/8/2 4:57 下午
 */
public class AnnotationDefinitionLoaderRegistry extends AbstractDefinitionLoaderRegistry {

    @Override
    public void loadBean() {
        System.out.println("loadBean by AnnotationDefinitionLoaderRegistry");
    }

}
