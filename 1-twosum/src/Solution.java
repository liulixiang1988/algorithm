import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 7, 5};
        int target = 9;

        int[] result = new Solution().twoSum(nums, target);
        System.out.printf("%d, %d", result[0], result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int item = target - nums[i];
            if (map.containsKey(item)) {
                return new int[]{map.get(item), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}