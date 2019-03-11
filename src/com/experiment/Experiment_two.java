package com.experiment;

import java.util.Scanner;

/*
 * @author:石建雷
 * @data: 2018.11.5
 *
 */
public class Experiment_two {

    public int sum(int i) {
        if (i > 0) {
            return i + 3;

        } else if (i == 0) {
            return i;
        } else
            return i * i - 1;
    }

    public static void main(String[] args) {

        Experiment_two two = new Experiment_two();
        System.out.print("请输入你想输入的数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(two.sum(num));


    }
}