import java.util.Arrays;
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
        HashMap<Integer, Integer> numOrderMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numOrderMap.put(nums[i], i);
        }

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        while (true) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                break;
            }
        }
        int finalI = nums[i];
        int finalJ = nums[j];
        return numOrderMap.entrySet().stream()
                .filter(entity -> entity.getKey() == finalI || entity.getKey() == finalJ)
                .mapToInt(Map.Entry::getValue).toArray();
    }
}