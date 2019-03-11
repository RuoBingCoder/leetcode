package hello;

/**
 * @author : 石建雷
 * @date :2019/1/25
 */

public class CharacterConversion {
    public static void main(String[] args) {
        String str1="a,b,c,d,e";
        String[] str2=str1.split(",");
        for (int i = 0; i <str2.length ; i++) {
            System.out.println(str2[i]);

        }
    }
}
