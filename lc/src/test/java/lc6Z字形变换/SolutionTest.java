package lc6Z字形变换;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void convert() {
        assertEquals("LCIRETOESIIGEDHN", solution.convert("LEETCODEISHIRING", 3));
        assertEquals("LECDIHRNETOESIIG", solution.convert("LEETCODEISHIRING", 2));
        assertEquals("LDREOEIIECIHNTSG", solution.convert("LEETCODEISHIRING", 4));
        assertEquals("LEET", solution.convert("LEET", 1));
        assertEquals("LE", solution.convert("LE", 3));
    }
}