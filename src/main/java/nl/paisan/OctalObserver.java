package nl.paisan;

/**
 * Created by paisanrietbroek on 23/01/2018.
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public String update() {
        String s = Integer.toOctalString(this.subject.getState());
        System.out.println("Octal string: " + s);
        return s;
    }
}
