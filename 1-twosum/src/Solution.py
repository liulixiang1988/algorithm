#!/usr/bin/env python
# -*- coding:utf-8 -*-

from typing import List, Dict

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numOrderDict: Dict[int, int] = {}
        for index, num in enumerate(nums):
            numLeft = target - num
            if numLeft in numOrderDict:
                return [numOrderDict[numLeft], index]
            numOrderDict[num] = index
        return None

if __name__ == "__main__":
    nums: List[int] = [1, 2, 3, 5]
    target: int = 3
    result = Solution().twoSum(nums, target)
    if result is not None:
        print(result[0], result[1])
