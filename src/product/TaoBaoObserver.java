package product;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : 石建雷
 * @date :2019/1/19
 */

public class TaoBaoObserver implements Observer {
    @Override
    public void update(Observable o, Object product) {
        String newProduct= (String) product;
        System.out.println("发送新产品【"+newProduct+"】同步到淘宝商城");

    }
}
