package interview.ref;

import java.lang.ref.SoftReference;

/**
 * @author : 石建雷
 * @date :2019/8/25
 * 软引用，只有在内存不满时不会被回收，当内存满时会回收
 */

public class SoftRef {
    /**
     * 软引用对象是在jvm内存不够的时候才会被回收，
     * 我们调用System.gc()方法只是起通知作用，JVM什么时候扫描回收对象是JVM自己的状态决定的。
     * 就算扫描到软引用对象也不一定会回收它，只有内存不够的时候才会回收
     *
     * @param args
     */
    public static void main(String[] args) {
        Object o = new Object();
        SoftReference<Object> reference = new SoftReference<>(o);
        o = null;
        System.gc();
        System.out.println(reference.get());
        System.out.println(reference);
    }
}
