package observermode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/7/28
 */

public class SubjectImpl implements ISubject {

    //存放订阅者
    private List<IObserver> observers = new ArrayList<>();

    private int version;

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void delObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String msg) {
        for (IObserver obs : observers) {
            obs.update(msg);

        }

    }
}
