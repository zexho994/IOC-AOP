package aop;

/**
 * @author Zexho
 * @date 2021/8/4 4:15 下午
 */
public class SubjectImpl implements ISubject {

    @Override
    public void subjectName() {
        System.out.println("subject impl name");
    }

    @Override
    public void request() {
        System.out.println("subject impl");
    }

}
