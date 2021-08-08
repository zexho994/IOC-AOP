package exceptions;

/**
 * @author Zexho
 * @date 2021/8/8 10:59 下午
 */
public class NotFoundAspectAdvice extends RuntimeException {

    public NotFoundAspectAdvice(String beanName) {
        super("not found advice in bean " + beanName);
    }

}
