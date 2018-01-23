package nl.paisan;

/**
 * Created by paisanrietbroek on 23/01/2018.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public String update() {

        String s = Integer.toBinaryString(this.subject.getState());
        System.out.println("Binary string: " + s);

        return s;
    }
}
