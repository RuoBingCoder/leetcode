package com.experiment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/*
 * @author:石建雷
 * @data: 2018.11.5
 *
 */
public class Experiment_sort {
    public static void main(String[] args) {

        int[] x = {25, 24, 12, 76, 101, 96, 28};
        Arrays.sort(x);

        for (int i = 0; i <x.length; i++) {
            System.out.print(x[i]+" ");
        }

    }

}
