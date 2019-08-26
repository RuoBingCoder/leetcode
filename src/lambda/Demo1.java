package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 石建雷
 * @date :2019/2/24
 */

public class Demo1 {
    public static class Calculator {

        interface IntegerMath {
            int operation(int a, int b);
        }

        public int operateBinary(int a, int b, IntegerMath op) {
            return op.operation(a, b);
        }


        public static void main(String... args) {

            Calculator myApp = new Calculator();
            IntegerMath addition = (a, b) -> a + b;
            IntegerMath subtraction = (a, b) -> a - b;
            System.out.println("40 + 2 = " +
                    myApp.operateBinary(40, 2, addition));
            System.out.println("20 - 10 = " +
                    myApp.operateBinary(20, 10, subtraction));
            System.out.println("======================1===========================");
            List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
            for (Integer cost : costBeforeTax) {
                double price = cost + .12*cost;
                System.out.println(price);
            }
            System.out.println("=======================1==========================");


            costBeforeTax.stream().map((cost)->cost+.12*cost).forEach(System.out::println);
            System.out.println("=======================2==========================");

            List<Integer> costBeforeTax1 = Arrays.asList(100, 200, 300, 400, 500);
            double total = 0;
            for (Integer cost : costBeforeTax1) {
                double price = cost + .12*cost;
                total = total + price;
            }
            System.out.println("Total : " + total);
            System.out.println("========================2=========================");

// 新方法：
            List<Integer> costBeforeTax2= Arrays.asList(100, 200, 300, 400, 500);
            double bill = costBeforeTax2.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum +
                    cost).get();
            System.out.println("Total : " + bill);
            System.out.println("========================3=========================");

            List<String> costBeforeTax3 = Arrays.asList("abc","bcd","defg","jk");
            List<String> newList = new ArrayList<>(4);
            for (String str:costBeforeTax3) {
                if (str.length() > 2) {
                    newList.add(str);

                }

            }
            System.out.println(newList.toString());
            System.out.println("========================3=========================");
//                java 8新特性
            List<String> streamList = costBeforeTax3.stream().filter((x) -> x.length() > 2).collect(Collectors.toList());

            System.out.println(streamList);

            System.out.println("=================================================");

            List<Integer> list = Arrays.asList(1, 3, 6, 12, 8, 34);
            int max = list.stream().mapToInt(x -> x).summaryStatistics().getMax();
            int min = list.stream().mapToInt(x -> x).summaryStatistics().getMin();
            int average = (int) list.stream().mapToInt(x -> x).summaryStatistics().getAverage();
            System.out.println(max);
            System.out.println(min);
            System.out.println(average);
        }


    }

}
