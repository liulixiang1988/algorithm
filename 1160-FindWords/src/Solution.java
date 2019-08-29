import java.util.HashMap;
import java.util.Map;

class Solution {
    public HashMap<Character, Integer> toMap(String str) {
        char[] array = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : array) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> containers = toMap(chars);
        int count = 0;
        for(String word: words) {
            HashMap<Character, Integer> wordMap = toMap(word);
            boolean in = true;
            for (Map.Entry<Character, Integer> entry:
                 wordMap.entrySet()) {
                if(containers.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    in = false;
                    break;
                }
            }

            if (in) {
                count += word.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int count = s.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach");
        System.out.println(count);
    }
}