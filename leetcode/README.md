[TOC]

## 链表

- 206 反转链表 （引入pre。现保存current的下一个，然后current.next = pre, pre = current, current = next)

## 数组

- 283 移动零（双指针，一遍遍历）
- 27 移动元素（交换、双指针）
- 26 删除排序数组中的重复项（27的变种）
- 80 删除排序数组中的重复项2 （27的变种，双指针）
- 70 颜色分类（双指针，一趟扫描，见27）

- 88 合并两个有序数组（从后往前合并）

## 栈

- 225 用队列实现栈（两个队列，每次压栈后做两个队列的置换）

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

## 搜索

- 695 岛屿的最大面积（dfs)：访问过的设置为0，同时返回各边探测之和
```java
private int dfs(int[][] grid, int x, int y) {
    int count = 1;
    for(int[] d : directions) {
        int newX = x + d[0];
        int newY = y + d[1];
        if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] != 0) {
            grid[newX][newY] = 0;
            count += dfs(grid, newX, newY);
        }
    }
    return count;
}
```
