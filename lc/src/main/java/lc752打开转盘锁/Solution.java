/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc752打开转盘锁;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * lc752打开转盘锁
 *
 * @since 2019-10-20
 */
public class Solution {

  public int openLock(String[] deadends, String target) {
    Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
    String start = "0000";
    if (deadendsSet.contains(start)) {
      return -1;
    }
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    deadendsSet.add(start);
    int step = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      step++;
      for (int i = 0; i < size; i++) {
        String str = queue.poll();
        if (str.equals(target)) {
          return step;
        }
        List<String> nexts = generate(str);
        for (String next : nexts) {
          if (deadendsSet.contains(next)) {
            continue;
          }
          deadendsSet.add(next);
          queue.offer(next);
        }
      }
    }
    return -1;
  }

  private List<String> generate(String initStr) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < initStr.length(); i++) {
      StringBuilder stringBuilder = new StringBuilder(initStr);
      char c = initStr.charAt(i);
      stringBuilder.setCharAt(i, c == '0' ? '9' : (char) (c - 1));
      result.add(stringBuilder.toString());
      stringBuilder.setCharAt(i, c == '9' ? '0' : (char) (c + 1));
      result.add(stringBuilder.toString());
    }
    return result;
  }
}
