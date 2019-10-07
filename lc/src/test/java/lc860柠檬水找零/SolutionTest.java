package lc860柠檬水找零;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void lemonadeChange() {
        Solution solution = new Solution();
        assertEquals(true, solution.lemonadeChange(new int[]{5,5,5,10,20}));
        assertEquals(true, solution.lemonadeChange(new int[]{5,5,10}));
        assertEquals(false, solution.lemonadeChange(new int[]{10,10}));
        assertEquals(false, solution.lemonadeChange(new int[]{5,5,10,10,20}));
        assertEquals(false, solution.lemonadeChange(new int[]{10}));
        assertEquals(false, solution.lemonadeChange(new int[]{20}));
        assertEquals(false, solution.lemonadeChange(new int[]{20, 5}));
    }
}