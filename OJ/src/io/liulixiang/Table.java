package io.liulixiang;

import java.util.Scanner;

/**
 * 打印类似mysql的表格(简单).
 *
 * @since 2019-09-04
 */
public class Table {

  /**
   * 主函数.
   * @param args 无用
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int n = in.nextInt();
      int m = in.nextInt();
      printTable(n, m);
    }
  }

  static void printTable(int n, int m) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= 2 * n; i++) {
      for (int j = 0; j < m; j++) {
        if (i % 2 == 0) {
          sb.append("+---");
        } else {
          sb.append("|   ");
        }
      }
      sb.append(i % 2 == 0 ? "+\n" : "|\n");
    }
    System.out.println(sb.toString());
  }

}
