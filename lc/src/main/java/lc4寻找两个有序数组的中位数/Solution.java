package lc4寻找两个有序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length2 < length1) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int temp2 = length1;
            length1 = length2;
            length2 = temp2;
        }
        int min1 = 0;
        int max1 = length1;
        int halfLen = (length1 + length2 + 1) / 2;
        while (min1 <= max1) {
            int i = (min1 + max1) / 2;
            int j = halfLen - i;
            if (i < max1 && nums2[j - 1] > nums1[i]) {
                min1 = i + 1;
            } else if (i > min1 && nums2[j] < nums1[i - 1]) {
                max1 = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((length1 + length2) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == length1) {
                    minRight = nums2[j];
                } else if (j == length2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
