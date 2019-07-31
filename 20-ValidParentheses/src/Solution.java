import java.util.*;

class Solution {
    Map<Character, Character> map;

    public Solution(){
        map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] items = s.toCharArray();
        for(char item : items) {
            if(map.containsKey(item)) {
                char match = stack.isEmpty() ? '#': stack.pop();
                if(match != map.get(item)) {
                    return false;
                }
            } else {
                stack.push(item);
            }
        }
        return stack.isEmpty();
    }
}