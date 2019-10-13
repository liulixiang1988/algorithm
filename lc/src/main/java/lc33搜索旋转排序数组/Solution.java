/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc33搜索旋转排序数组;

/**
 * lc33搜索旋转排序数组
 *
 * @since 2019-10-13
 */
public class Solution {

  protected int searchRotateIndex(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    if (nums[left] <= nums[right]) {
      return 0;
    }

    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[mid + 1]) {
        return mid;
      }
      if (nums[mid] < nums[left]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return 0;
  }

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    int rotateIndex = searchRotateIndex(nums);
    int left = 0;
    int right = nums.length - 1;
    if (nums[left] <= target && target <= nums[rotateIndex]) {
      right = rotateIndex;
    } else {
      left = rotateIndex + 1;
    }
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
