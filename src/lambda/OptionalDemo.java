package lambda;

import java.util.Optional;

/**
 * @author : 石建雷
 * @date :2019/8/15
 */

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> opl = Optional.of("sujianhua");
        Optional<String> upperName = opl.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found!"));
        //  flatMap 与 map（Function）非常类似，区别在于传入方法的 lambda 表达式的返回类型。
        //map 方法中的 lambda 表达式返回值可以是任意类型，在 map 函数返回之前会包装为 Optional。
        //但 flatMap 方法中的 lambda 表达式返回值必须是 Optionl 实例。

        upperName.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found!"));

        //filter 方法检查给定的 Option 值是否满足某些条件。
        //如果满足则返回同一个 Option 实例，否则返回空 Optional。
        Optional<String> longName = opl.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));

    }
}
