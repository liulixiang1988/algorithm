/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc17电话号码的字母组合;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void letterCombinations() {
    Solution solution = new Solution();
    List<String> output = solution.letterCombinations("23");
    List<String> exp = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    Assertions.assertTrue(exp.containsAll(output));
    Assertions.assertTrue(output.containsAll(exp));
  }
}