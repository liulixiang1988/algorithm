[TOC]

## 数组

- 283 移动零（双指针，一遍遍历）
- 27 移动元素（交换、双指针）
- 26 删除排序数组中的重复项（27的变种）
- 80 删除排序数组中的重复项2 （27的变种，双指针）
- 70 颜色分类（双指针，一趟扫描，见27）

## 树

- 104 二叉树的最大深度

```java
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
}
```
