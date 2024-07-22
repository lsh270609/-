import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<List<Integer>> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek().get(0) > prices[i]) {
                int idx = stack.pop().get(1);
                answer[idx] = i - idx;
            }
            stack.add(List.of(prices[i], i));
        }
        while(!stack.isEmpty()) {
            int idx = stack.pop().get(1);
            answer[idx] = len - 1 - idx;
        }
        
        return answer;
    }
}