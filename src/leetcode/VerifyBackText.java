package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 石建雷
 * @date :2019/7/19
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * amanaplana c analpanama
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class VerifyBackText {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        List<Character> characterList = new ArrayList<>();
        String str = s.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                characterList.add(str.charAt(i));
            }
        }
        System.out.println(characterList.toString());
        int count = 0;
//        aba
        for (int i = 0; i < characterList.size() / 2; i++) {
            if (characterList.get(i).equals(characterList.get(characterList.size() - i - 1))) {
                count++;
            }
        }
        if (count == characterList.size() / 2) {
            return true;
        }
        System.out.println(characterList.toString().toLowerCase());
        return false;
    }

    public static void main(String[] args) {
        VerifyBackText verifyBackText = new VerifyBackText();
        System.out.println(verifyBackText.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(verifyBackText.isPalindrome("race a car"));
        System.out.println(verifyBackText.isPalindrome("0p"));
    }

    /*if (s == null) {
            return true;
        }
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                characterList.add(s.charAt(i));
            }
        }
        System.out.println(characterList.toString().toLowerCase());
        StringBuilder sb = new StringBuilder().append(characterList.toString().toLowerCase());
        Collections.reverse(characterList);
        if (sb.toString().equals(characterList.toString().toLowerCase())) {
            return true;
        }
        System.out.println(characterList.toString().toLowerCase());
        return false;*/
}
