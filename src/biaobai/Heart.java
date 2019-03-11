package biaobai;

/**
 * @author : 石建雷
 * @date :2019/2/18
 */

public class Heart {
    private static int k = 0;
    private static int m = 0;

    private void painting() {
        for (int i = 0; i < 4; i++) {
            for (k = 2; k >= i; k--) {
                System.out.print(" ");
            }

            for (int j = 0; j < 6 + 2 * i; j++) {
                System.out.print("*");

            }

            for (m = 2; m >= 0; m--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (k = 2; k >= i; k--) {
                System.out.print(" ");
            }

            for (int j = 0; j < 6 + 2 * i; j++) {
                System.out.print("*");

            }

            for (m = 2; m >= 0; m--) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Heart heart = new Heart();
        heart.painting();
    }
}
