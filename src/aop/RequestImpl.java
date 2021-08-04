package aop;

/**
 * @author Zexho
 * @date 2021/8/4 4:40 下午
 */
public class RequestImpl implements IRequest {
    @Override
    public void request() {
        System.out.println("request impl");
    }
}
