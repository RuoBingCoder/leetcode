package com.experiment;

import java.util.Scanner;

/*
 * @author:石建雷
 * @data: 2018.11.7
 *
 */
public class Login_game {

    private static String password = "123456";

    public void login(String num) {


        if (num.equals(password)) {

            System.out.println("登录成功！");


        } else
            System.out.println("请重新输入！");
    }


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {


            System.out.print("请输入密码：");
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            Login_game login_game = new Login_game();
            login_game.login(input);
            if (input.equals(password)) {
                break;
            }

        }

    }
}
