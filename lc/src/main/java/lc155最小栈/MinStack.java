/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc155最小栈;

import java.util.Stack;

/**
 * lc155最小栈
 *
 * @since 2019-10-23
 */
public class MinStack {

  Stack<Integer> data;
  Stack<Integer> helper;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    data = new Stack<>();
    helper = new Stack<>();
  }

  public void push(int x) {
    data.push(x);

    if (helper.empty() || helper.peek() >= x) {
      helper.push(x);
    } else {
      helper.push(helper.peek());
    }
  }

  public void pop() {
    if (data.empty()) {
      return;
    }
    data.pop();
    helper.pop();
  }

  public int top() {
    return data.peek();
  }

  public int getMin() {
    return helper.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */