import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) return 0;
        Stack<String> stack = new Stack<>();
        for (String str : s.split("")) {
            if (stack.size() != 0 && stack.lastElement().equals(str)) {
                stack.pop();
            } else {
                stack.add(str);
            }
        }
        if(stack.size() == 0) return 1;
        else return 0;
    }
}