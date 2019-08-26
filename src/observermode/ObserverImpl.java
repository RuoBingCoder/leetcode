package observermode;

/**
 * @author : 石建雷
 * @date :2019/7/28
 */

public class ObserverImpl implements IObserver {

    private String name;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + "的信息是" + msg);
    }
}
