/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc224基本计算器;

import java.util.Stack;

/**
 * lc224基本计算器
 *
 * @since 2019-10-25
 */
public class Solution {

  private Stack<Integer> data = new Stack<>();
  private Stack<Character> operator = new Stack<>();

  public int calculate(String s) {
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; ) {
      if (chars[i] == ' ') {
        i++;
        continue;
      }
      // 如果是操作符，放入栈
      if (chars[i] == '+' || chars[i] == '-' || chars[i] == '(') {
        operator.push(chars[i]);
        i++;
        continue;
      }
      // 如果是右括号，则弹出堆栈进行计算
      if (chars[i] == ')') {
        while (!operator.empty()) {
          char op = operator.pop();
          if (op == '(') {
            break;
          }
          calc();
        }
        calc();
        i++;
        continue;
      }
      int temp = 0;
      while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
        temp = temp * 10 + chars[i] - '0';
        i++;
      }
      data.push(temp);
      calc();
    }
    if (!operator.empty()) {
      calc();
    }
    return data.pop();
  }

  private void calc() {
    while (!operator.empty() && operator.peek() != '(' && data.size() >= 2) {
      //System.out.printf("%s, %s\n", data, operator);
      char op = operator.pop();
      int y = data.pop();
      int x = data.pop();
      switch (op) {
        case '+':
          data.push(x + y);
          break;
        case '-':
          data.push(x - y);
          break;
      }
      //System.out.printf("--->%s, %s\n", data, operator);
    }
  }
}
