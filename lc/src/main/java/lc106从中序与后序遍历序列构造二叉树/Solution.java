/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc106从中序与后序遍历序列构造二叉树;

import common.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * lc106从中序与后序遍历序列构造二叉树
 *
 * @since 2019-10-19
 */
public class Solution {

  private int[] inorder;
  private int[] postorder;
  private Map<Integer, Integer> inorderIdxMap = new HashMap<>();
  private int postorderIdx;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length
        || inorder.length * postorder.length == 0) {
      return null;
    }
    this.inorder = inorder;
    this.postorder = postorder;
    for (int i = 0; i < inorder.length; i++) {
      // 将中序遍历的映射关系添加到map中
      inorderIdxMap.put(inorder[i], i);
    }
    postorderIdx = postorder.length - 1;
    return helper(0, inorder.length);
  }

  private TreeNode helper(int left, int right) {
    if (left == right) {
      return null;
    }
    int value = postorder[postorderIdx];
    TreeNode root = new TreeNode(value);
    int inorderIdx = inorderIdxMap.get(value);
    // 从右向左遍历，因为后续遍历根节点在右侧
    postorderIdx--;

    root.right = helper(inorderIdx + 1, right);
    root.left = helper(left, inorderIdx);
    return root;
  }
}
