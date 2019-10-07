package lc860柠檬水找零;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[]{0, 0, 0, 0};
        for (int bill : bills) {
            changes[bill/5 - 1] += 1;
            if (bill == 10) {
                if (changes[0] == 0) {
                    return false;
                }
                changes[0] -= 1;
            }
            if (bill == 20) {
                if (changes[0] == 0) {
                    return false;
                }
                if (changes[1] == 0) {
                    if (changes[0] < 3) {
                        return false;
                    }
                    changes[0] -= 3;
                } else {
                    changes[1] -= 1;
                    changes[0] -= 1;
                }
            }
        }
        return true;
    }
}
