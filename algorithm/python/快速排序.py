#!/usr/bin/env python
# -*- coding:utf-8 -*-

def getIndex(arr, left, right):
    """
    1. 选择右边作为中轴
    2. 从左往右，左边赋值给右边
    3. 从右往左，右边赋值给左边
    """
    pivot = arr[right]
    while left < right:
        while arr[left] <= pivot and left < right:
            left += 1
        arr[right] = arr[left]
        while arr[right] >= pivot and left < right:
            right -= 1
        arr[left] = arr[right]
    arr[right] = pivot
    return right

def quickSort(arr, left, right):
    """
    1. 找中轴
    2. 左边快排
    3. 右边快排
    """
    if left < right:
        index = getIndex(arr, left, right)
        quickSort(arr, left, index - 1)
        quickSort(arr, index + 1, right)
if __name__ == "__main__":
    arr = [1, -1, 9, 0, -7, 2, -4, 13, 5, 1]
    n = len(arr)
    quickSort(arr, 0, n - 1)
    print(arr)