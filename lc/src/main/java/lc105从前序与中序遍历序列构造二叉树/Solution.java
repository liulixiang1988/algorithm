/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc105从前序与中序遍历序列构造二叉树;

import common.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * lc105从前序与中序遍历序列构造二叉树
 *
 * @since 2019-10-16
 */
public class Solution {

  private int[] preorder;
  private int[] inorder;
  private int preIndex = 0;
  private Map<Integer, Integer> inorderIdxMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length * inorder.length == 0
        || preorder.length != inorder.length) {
      return null;
    }
    this.preorder = preorder;
    this.inorder = inorder;
    for (int i = 0; i < inorder.length; i++) {
      inorderIdxMap.put(inorder[i], i);
    }
    return helper(0, inorder.length);
  }

  private TreeNode helper(int left, int right) {
    if (left == right) {
      return null;
    }
    //获取当前根节点的值
    int value = preorder[preIndex];
    TreeNode root = new TreeNode(value);

    int inorderIndex = inorderIdxMap.get(value);
    preIndex++;

    root.left = helper(left, inorderIndex);
    root.right = helper(inorderIndex + 1, right);
    return root;
  }
}
