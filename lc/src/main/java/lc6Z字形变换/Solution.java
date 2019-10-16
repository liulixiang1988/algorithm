package lc6Z字形变换;

public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j * (2 * numRows - 2) + i < s.length(); j++) {
                stringBuilder.append(s.charAt(i + j * (2 * numRows - 2)));
                int innerIndex = (j + 1) * (2 * numRows - 2) - i;
                if (i % numRows > 0 && i % numRows < numRows - 1 && innerIndex < s.length()) {
                    stringBuilder.append(s.charAt(innerIndex));
                }
            }
        }
        return stringBuilder.toString();
    }
}
