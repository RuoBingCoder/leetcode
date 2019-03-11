package com.experiment;

import java.util.ArrayList;

/*
 * @author:石建雷
 * @data: 2018.11.6
 *
 */
public class Experiment_str {


    public static void main(String[] args) {

        String s = "HelloWorld";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {   //Character用于对单个字符进行操作


                stringBuffer.append(Character.toLowerCase(c));


            } else if (Character.isLowerCase(c))

                stringBuffer.append(Character.toUpperCase(c));
        }
        System.out.println(stringBuffer.toString());
    }

}
