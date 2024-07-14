import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 1;
        Stack<Integer> out = new Stack<>();
        Stack<Integer> conv2 = new Stack<>();
        for (int i = 1; i < order[0]; i++) {
            conv2.add(i);
        }
        out.push(order[0]);

        for (int i = 1; i < order.length; i++) {
            int tmp = out.peek();
            if (tmp > order[i]) {
                if (order[i] == conv2.peek()) {
                    answer++;
                    conv2.pop();
                } else break;
            } else {
                for(int j = tmp + 1; j < order[i]; j++) {
                    conv2.push(j);			
                }
                answer++;
                out.push(order[i]);
            }
        }

        return answer;
    }
}