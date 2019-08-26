package threaddemo.thread;

/**
 * @author : 石建雷
 * @date :2019/8/5
 */

public class Run {
    /**
     *
     * count=100
     * count=200
     * count=300
     * count=400
     * count=500
     * count=600
     * count=700
     * count=800
     * count=900
     * count=1000
     * count=1100
     * count=1200
     * count=1300
     * count=1400
     * count=1500
     * count=1600
     * count=1700
     * count=1800
     * count=1900
     * count=2000
     * count=2100
     * count=2200
     * count=2300
     * count=2400
     * count=2500
     * count=2600
     * count=2700
     * count=2800
     * count=2900
     * count=3000
     * count=3100
     * count=3200
     * count=3300
     * count=3400
     * count=3500
     * count=3600
     * count=3700
     * count=3800
     * count=3900
     * count=4000
     * count=4100
     * count=4200
     * count=4300
     * count=4400
     * count=4500
     * count=4600
     * count=4800
     * count=4900
     * count=5000
     * count=5100
     * count=4700
     * count=5560
     * count=5760
     * count=5660
     * count=5460
     * count=5960
     * count=6160
     * count=6260
     * count=6360
     * count=5360
     * count=5360
     * count=5200
     * count=6460
     * count=6560
     * count=6960
     * count=6060
     * count=5860
     * count=7160
     * count=7060
     * count=6860
     * count=6760
     * count=6660
     * count=9960
     * count=9960
     * count=9960
     * count=9860
     * count=9760
     * count=9460
     * count=9360
     * count=9260
     * count=9160
     * count=9060
     * count=8960
     * count=8860
     * count=8760
     * count=8660
     * count=8560
     * count=8460
     * count=8360
     * count=8260
     * count=8160
     * count=8160
     * count=7960
     * count=7860
     * count=7806
     * count=7660
     * count=7560
     * count=7460
     * count=7360
     * count=7260
     * 预期结果100*100
     * volatile不能保证线程的安全性
     * @param args
     */
    public static void main(String[] args) {
        MyThread[] mythreadArray = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }
    }
}
