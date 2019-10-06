/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc67二进制求和;

public class Solution {
    public String addBinary(String a, String b) {
        int aa = Integer.valueOf(a, 2);
        int bb = Integer.valueOf(b, 2);
        int r = aa + bb;
        return Integer.toBinaryString(r);
    }
}
