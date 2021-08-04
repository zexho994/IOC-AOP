package aop;

/**
 * @author Zexho
 * @date 2021/8/4 4:15 下午
 */
public class SubjectProxy implements ISubject {

    private final ISubject subject;

    public SubjectProxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        subject.request();
        this.after();
    }

    public void before() {
        System.out.println("proxy -> before");
    }

    public void after() {
        System.out.println("proxy -> after");
    }

}
