/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc26删除数组重复项;

/**
 * lc26删除数组重复项
 *
 * @since 2019-10-16
 */
public class Solution {

  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if (nums.length < 2) {
      return nums.length;
    }
    int slow = 0, fast = 1;
    while (fast < nums.length) {
      if (nums[slow] != nums[fast] && ++slow < fast) {
        nums[slow] = nums[fast];
      }
      fast++;
    }
    return ++slow;
  }
}