package interview.ref;

import java.lang.ref.WeakReference;

/**
 * @author : 石建雷
 * @date :2019/8/25
 * 弱引用
 */

public class WeakRef {
    public static void main(String[] args) {
        Object o=new Object();
        WeakReference<Object> reference=new WeakReference(o);
        o = null;
        System.gc();
        System.out.println(o);
        System.out.println(reference.get());
//        null,null
    }
}
