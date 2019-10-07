package lc917仅仅反转字母;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseOnlyLetters() {
        Solution solution = new Solution();
//        assertEquals("dc-ba", solution.reverseOnlyLetters("ab-cd"));
//        assertEquals("j-Ih-gfE-dCba", solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
//        assertEquals("Qedo1ct-eeLg=ntse-T!", solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
//        assertEquals("$Qedo1ct-eeLg=ntse-T!", solution.reverseOnlyLetters("$Test1ng-Leet=code-Q!"));
        assertEquals("-", solution.reverseOnlyLetters("-"));
        assertEquals("", solution.reverseOnlyLetters(""));
    }
}