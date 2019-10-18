/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc179最大数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * lc179最大数
 *
 * @since 2019-10-18
 */
public class Solution {

  public String largestNumber(int[] nums) {
    String[] numsStr = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numsStr[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(numsStr, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        return (b + a).compareTo((a + b));
      }
    });
    if (numsStr[0].equals("0")) {
      return "0";
    }
    return String.join("", numsStr);
  }
}
