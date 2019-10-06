/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * lc17电话号码的字母组合
 *
 * @since 2019-10-06
 */
public class Solution {

  private Map<String, String> phone = new HashMap<>();
  private List<String> output = new ArrayList<>();

  public Solution() {
    phone.put("2", "abc");
    phone.put("3", "def");
    phone.put("4", "ghi");
    phone.put("5", "jkl");
    phone.put("6", "mno");
    phone.put("7", "pqrs");
    phone.put("8", "tuv");
    phone.put("9", "wxyz");
  }

  private void backtrack(String combination, String next_digits) {
    if (next_digits.length() == 0) {
      output.add(combination);
      return;
    }
    String digit = next_digits.substring(0, 1);
    String letters = phone.get(digit);
    for (int i = 0; i < letters.length(); i++) {
      String letter = letters.substring(i, i + 1);
      backtrack(combination + letter, next_digits.substring(1));
    }
  }


  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0) {
      backtrack("", digits);
    }
    return output;
  }
}
