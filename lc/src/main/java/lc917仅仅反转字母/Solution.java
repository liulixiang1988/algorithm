package lc917仅仅反转字母;

public class Solution {
    public String reverseOnlyLetters(String S) {
        if(S.length() == 0){
            return S;
        }
        int i = 0;
        int j = S.length() - 1;
        char[] chars = S.toCharArray();
        while (true) {
            while(i < S.length() && (chars[i] < 'a' || chars[i] > 'z') && (chars[i] < 'A' || chars[i] > 'Z')) {
                i++;
            }
            while(j >= 0 && (chars[j] < 'a' || chars[j] > 'z') && (chars[j] < 'A' || chars[j] > 'Z')) {
                j--;
            }
            if(i >= j) {
                break;
            }
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;

        }
        return String.copyValueOf(chars);
    }
}
