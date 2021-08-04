package aop;

/**
 * @author Zexho
 * @date 2021/8/4 4:18 下午
 */
public class Client {
    public static void main(String[] args){
        ISubject subject = new SubjectImpl();
        ISubject subjectProxy = new SubjectProxy(subject);

        subjectProxy.request();
    }
}
