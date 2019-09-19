/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc53最大子序和;

/**
 * TODO Class Description
 *
 * @since 2019-09-19
 */
public class Solution {

  public int maxSubArray(int[] nums) {
    if (nums == null) {
      return 0;
    }
    int ans = nums[0];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sum > 0) {
        sum += nums[i];
      } else {
        sum = nums[i];
      }
      ans = Math.max(ans, sum);
    }
    return ans;
  }
}
