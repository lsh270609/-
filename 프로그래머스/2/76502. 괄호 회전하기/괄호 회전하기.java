import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String[] arr = { "[]", "{}", "()" };
        StringBuilder ss = new StringBuilder(s);

        for (int i = 0; i < len; i++) {
            answer += check(arr, ss.toString());
            String tmp = ss.subSequence(0, 1).toString();
            ss.delete(0, 1).append(tmp);
        }
        return answer;
    }

    public int check(String[] arr, String s) {
        HashMap<String, String> map = new HashMap<>();
        for (String str : arr) {
            String[] tmp = str.split("");
            map.put(tmp[1], tmp[0]);
        }
        Stack<String> stack = new Stack<>();
        for (String str : s.split("")) {
            if (map.values().contains(str)) {
                stack.push(str);
            } else if (stack.size() != 0 && map.get(str).equals(stack.get(stack.size()-1))) {
                stack.pop();
            } else if (stack.size() == 0) {
                return 0;
            }
        }
        if (stack.size() == 0) return 1;			
        else return 0;
    }
}