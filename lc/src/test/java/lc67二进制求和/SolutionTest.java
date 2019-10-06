/*
 * Copyright (c) Liu Lixiang 2019-2019. All rights reserved
 */

package lc67二进制求和;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    void addBinary() {
        Solution solution = new Solution();
        assertEquals("1110", solution.addBinary("1101", "1"));
        assertEquals("10000", solution.addBinary("1111", "1"));
        assertEquals("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000", solution.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
                , "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}