package observermode;

/**
 * @author : 石建雷
 * @date :2019/7/28
 */

public class MainTest {
    public static void main(String[] args) {
        ObserverImpl observer = new ObserverImpl("张三");
        ObserverImpl observer1 = new ObserverImpl("李四");
        ObserverImpl observer2 = new ObserverImpl("王五");
        observer.update("第一期杂志");
        observer1.update("第二期杂志");
        observer2.update("第三期杂志");
        System.out.println("==========================================");
        SubjectImpl subject=new SubjectImpl();
        subject.addObserver(observer);
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.delObserver(observer);
        System.out.println("==========================================");
        subject.notifyObserver("我今天很开心");



    }
}
