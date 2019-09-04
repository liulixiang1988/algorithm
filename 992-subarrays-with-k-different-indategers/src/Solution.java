import java.util.HashMap;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * <p>
 * 返回 A 中好子数组的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：A = [1,2,1,2,3], K = 2 输入：7 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2],
 * [1,2,1,2]. 示例 2：
 * <p>
 * 输入：A = [1,2,1,3,4], K = 3 输出：3 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000 1 <= A[i] <= A.length 1 <= K <= A.length
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

  public int subarraysWithKDistinct(int[] A, int K) {
    int left = 0;
    int right = 0;
    HashMap<Integer, Integer> wordCount = new HashMap<>();
    int res = 0;
    for (; right < A.length; right++) {
      //如果不包含key，需要看下加上去后会不会超出
      if (!wordCount.containsKey(A[right]) && wordCount.keySet().size() == K) {
        while (wordCount.keySet().size() == K) {
          wordCount.remove(A[left]);
          left++;
          res += 1;
        }
      }
      wordCount.put(A[right], wordCount.getOrDefault(A[right], 0) + 1);

      while (wordCount.keySet().size() > K) {
        wordCount.remove(left);
        left++;
      }

      if (wordCount.keySet().size() == K) {
        res += 1;
      }
    }
  }
}