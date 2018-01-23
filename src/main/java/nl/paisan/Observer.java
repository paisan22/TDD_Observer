package nl.paisan;

/**
 * Created by paisanrietbroek on 23/01/2018.
 */
public abstract class Observer {

    protected Subject subject;
    public abstract String update();
}
