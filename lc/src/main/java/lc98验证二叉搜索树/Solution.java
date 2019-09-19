/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc98验证二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2019-09-17
 */
public class Solution {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  List<Integer> values = new ArrayList<>();

  //解法1，中序遍历后从小到大遍历一遍
  public boolean isValidBST(TreeNode root) {
    inOrder(root);
    Integer pre = null;
    for (int val : values) {
      if (pre != null && val <= pre) {
        return false;
      }
      pre = val;
    }
    return true;
  }

  private void inOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    values.add(node.val);
    inOrder(node.right);
  }

  //解法2，左子树比根节点值都要小，右子树比根节点值要大，因此传入一个最大值，一个最小值，然后进行递归比较
  public boolean isValidBST2(TreeNode root) {
    return isValid(root, null, null);
  }

  private boolean isValid(TreeNode root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }
    if (max != null && root.val >= max) {
      return false;
    }
    if (min != null && root.val <= min) {
      return false;
    }
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
  }

  //解法3，解法1中遍历所有节点时使用了列表存储所有节点，其实每次只存储前面一个节点，用当前值与前面节点值比较
  private Integer pre = null;

  public boolean isValidBST3(TreeNode root) {
    if (root == null) {
      return true;
    }
    //先遍历左子树，如果左子树不是二叉搜索树就返回false
    if (!isValidBST3(root.left)) {
      return false;
    }
    //比较root节点与pre的值，如果不比pre大，返回
    if (pre != null && root.val <= pre) {
      return false;
    }
    //遍历了root节点后，root就变成了pre
    pre = root.val;
    //遍历右子树
    return isValidBST3(root.right);
  }
}
