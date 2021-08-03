package exceptions;

/**
 * @author Zexho
 * @date 2021/7/31 11:06 上午
 */
public class NoSuchBeanException extends RuntimeException {

    public NoSuchBeanException(String name) {
        super("No bean named " + name + " available");
    }

    public NoSuchBeanException(String name, Class<?> clazz) {
        super("No bean named " + name + ", class " + clazz.getName() + " available");
    }

}
