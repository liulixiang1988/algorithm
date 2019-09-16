/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 三数之和 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 题解：https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
 *
 * @since 2019-09-16
 */
public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        break;
      }
      Set<Integer> set = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        if (set.contains(-nums[i] - nums[j])) {
          List<Integer> r = new ArrayList<>();
          r.add(nums[i]);
          r.add(nums[j]);
          r.add(-nums[i] - nums[j]);
          r.sort(Comparator.comparingInt(a -> a));
          if (!result.contains(r)) {
            result.add(r);
          }
        }
        set.add(nums[j]);
      }
    }
    return result;
  }

  public List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) {
        break;
      }

      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int left = i + 1, right = nums.length - 1; left < right; ) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum > 0) {
          while (left < right && nums[right] == nums[--right]) {
            ;
          }
        } else if (sum < 0) {
          while (left < right && nums[left] == nums[++left]) {
            ;
          }
        } else {
          List<Integer> r = new ArrayList<>();
          r.add(nums[i]);
          r.add(nums[left]);
          r.add(nums[right]);
          result.add(r);
          while (left < right && nums[right] == nums[--right]) {
            ;
          }
          while (left < right && nums[left] == nums[++left]) {
            ;
          }
        }
      }
    }
    return result;
  }
}
