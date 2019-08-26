package observermode;

/**
 * @author : 石建雷
 * @date :2019/7/28
 */

public interface ISubject {
//添加观察者
    void addObserver(IObserver observer);
    void delObserver(IObserver observer);
    //当主题方法改变时,这个方法被调用,通知所有的观察者
    void notifyObserver(String msg);
}
