package hello;

/**
 * @author : 石建雷
 * @date :2019/2/6
 */

public class Allperm {
    public static class AllPerm {
        public static void main(String[] args) {
            String s = "abc";
            perm(s.toCharArray(), 0, s.length() - 1);
        }

        private static void swap(char[] str, int a, int b) {
            char temp = str[a];
            str[a] = str[b];
            str[b] = temp;
        }

        public static void perm(char[] str, int from, int to) {
            if (from == to) {
                System.out.println(str);
                return;
            }
            for (int j = from; j <= to; j++) {
                swap(str, from, j);
                perm(str, from + 1, to);
                swap(str, from, j);
            }
        }
    }
}
