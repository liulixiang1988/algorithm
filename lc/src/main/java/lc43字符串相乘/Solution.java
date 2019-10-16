/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc43字符串相乘;

/**
 * lc43字符串相乘
 *
 * @since 2019-10-16
 */
public class Solution {

  public String multiply(String num1, String num2) {
    String result = "0";
    char[] letter1 = num1.toCharArray();
    char[] letter2 = num2.toCharArray();
    if (letter1[0] == '0' || letter2[0] == '0') {
      return "0";
    }
    for (int i = letter1.length - 1; i >= 0; i--) {
      if (letter1[i] == '0') {
        continue;
      }
      int a = letter1[i] - '0';
      int carry = 0;
      StringBuilder stringBuilder = new StringBuilder();
      for (int j = letter2.length - 1; j >= 0; j--) {
        int b = letter2[j] - '0';
        int current = (a * b + carry) % 10;
        carry = (a * b + carry) / 10;
        stringBuilder.insert(0, current);
      }
      if (carry > 0) {
        stringBuilder.insert(0, carry);
      }
      for (int m = 0; m < letter1.length - i - 1; m++) {
        stringBuilder.append('0');
      }
      result = add(result, stringBuilder.toString());
    }
    return result.startsWith("0") ? "0" : result;
  }

  private String add(String a, String b) {
    StringBuilder stringBuilder = new StringBuilder();
    int carry = 0;
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; ) {
      if (i >= 0 && j >= 0) {
        int res = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
        int current = res % 10;
        carry = res / 10;
        stringBuilder.insert(0, current);
        continue;
      }
      if (j >= 0) {
        i = j;
        j = -1;
        a = b;
      }
      int temp = a.charAt(i) - '0' + carry;
      stringBuilder.insert(0, temp % 10);
      carry = temp / 10;
      i--;
    }
    if (carry > 0) {
      stringBuilder.insert(0, carry);
    }
    return stringBuilder.toString();
  }
}
