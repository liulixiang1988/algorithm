/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 * <p>
 * 滑动窗口的位置                最大值 ---------------               ----- [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3 1  3 [-1  -3  5] 3  6  7       5 1  3  -1 [-3  5  3] 6  7 5 1  3
 * -1  -3 [5  3  6] 7       6 1  3  -1  -3  5 [3  6  7]      7  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2019-09-16
 */
public class Solution {

  /*
   * 使用优先级队列
   */
  public int[] maxSlidingWindow(int[] nums, int k) {

    if (nums.length == 0) {
      return new int[0];
    }
    int[] res = new int[nums.length - k + 1];
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (a, b) -> b - a);
    for (int i = 0; i < k - 1; i++) {
      priorityQueue.add(nums[i]);
    }
    for (int i = k - 1; i < nums.length; i++) {
      priorityQueue.add(nums[i]);
      res[i - k + 1] = priorityQueue.peek();
      priorityQueue.remove(nums[i - k + 1]);
    }
    return res;
  }

  /*
  使用滑动窗口
   */
  public int[] maxSlidingWindow2(int[] nums, int k) {
    if (nums.length == 0) {
      return new int[0];
    }
    List<Integer> win = new ArrayList<>();
    int[] res = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      final int index = i;
      win.replaceAll(a -> a >= nums[index] ? a : nums[index]);
      win.add(nums[i]);

      if (i < k - 1) {
        continue;
      }

      res[i - k + 1] = win.get(0);
      win.remove(0);
    }
    return res;
  }

  public int[] maxSlidingWindow3(int[] nums, int k) {
    if (nums.length == 0 || k == 0) {
      return new int[0];
    }

    if (k == 1) {
      return nums;
    }

    int[] res = new int[nums.length - k + 1];
    Deque<Integer> window = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (window.size() > 0 && nums[window.peekLast()] < nums[i]) {
        window.removeLast();
      }
      window.addLast(i);
      if (i < k - 1) {
        continue;
      }
      res[i - k + 1] = nums[window.peekFirst()];
      if (window.peekFirst() <= i - k + 1) {
        window.pollFirst();
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.maxSlidingWindow3(new int[]{7, 2, 4}, 2)));
    System.out.println(
        Arrays.toString(solution.maxSlidingWindow3(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
  }
}
