/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc150逆波兰表达式求值;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * lc150逆波兰表达式求值
 *
 * @since 2019-10-25
 */
public class Solution {

  Stack<Integer> data = new Stack<>();
  Set<String> operatorSet = new HashSet<>();

  public Solution() {
    operatorSet.add("+");
    operatorSet.add("-");
    operatorSet.add("*");
    operatorSet.add("/");
  }

  public int evalRPN(String[] tokens) {
    int length = tokens.length;
    for (int i = 0; i < length; i++) {
      if (operatorSet.contains(tokens[i])) {
        calc(tokens[i]);
      } else {
        data.push(Integer.valueOf(tokens[i]));
      }
    }

    return data.pop();
  }

  private void calc(String op) {
    int y = data.pop();
    int x = data.pop();
    switch (op) {
      case "+":
        data.push(x + y);
        break;
      case "-":
        data.push(x - y);
        break;
      case "*":
        data.push(x * y);
        break;
      case "/":
        data.push(x / y);
        break;
    }
  }
}
