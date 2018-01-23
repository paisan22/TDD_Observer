package nl.paisan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/01/2018.
 */
public class Subject {

    private List<Observer> observerList = new ArrayList<Observer>();

    private int state = 0;

    public int getState() {
        return this.state;
    }

    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void notifyAllObservers() {
        for(Observer o:this.observerList) {
            o.update();
        }
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
}
