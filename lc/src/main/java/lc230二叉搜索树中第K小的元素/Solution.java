/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc230二叉搜索树中第K小的元素;

import common.TreeNode;

/**
 * lc230二叉搜索树中第K小的元素
 *
 * @since 2019-10-19
 */
public class Solution {

  private int k;
  private int result;

  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    kthSmallest(root);
    return result;
  }

  private void kthSmallest(TreeNode root) {

    if (root.left != null) {
      kthSmallest(root.left);
    }
    k--;
    if (k == 0) {
      result = root.val;
      return;
    }
    if (k > 0 && root.right != null) {
      kthSmallest(root.right);
    }
  }
}
