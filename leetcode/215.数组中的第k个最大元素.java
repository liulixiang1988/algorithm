import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (58.88%)
 * Likes:    282
 * Dislikes: 0
 * Total Accepted:    53.5K
 * Total Submissions: 90.9K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int num : nums) {
            priorityQueue.add(num);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivot = getIndex(nums, left, right);
        if (pivot == k) {
            return nums[pivot];
        }
        if (pivot > k) {
            return quickSelect(nums, left, pivot-1, k);
        }
        return quickSelect(nums, pivot + 1, right, k);
    }

    private int getIndex(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (nums[right] <= pivot && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] >= pivot && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
// @lc code=end

