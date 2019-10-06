/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc67二进制求和;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry =0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0': 0;
            sum += j >= 0 ? b.charAt(j) - '0': 0;
            sb.append(sum%2);
            carry = sum/2;
        }
        sb.append(carry == 1 ? "1": "");
        return sb.reverse().toString();
    }
}
