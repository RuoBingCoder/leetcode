package observermode;

/**
 * @author : 石建雷
 * @date :2019/7/28
 */

public interface IObserver {

    //当主题状态改变时,更新通知
     void update(String msg);
}
