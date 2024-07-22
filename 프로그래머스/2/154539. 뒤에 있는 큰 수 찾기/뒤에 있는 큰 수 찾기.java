import java.util.*;

class Solution {
	public int[] solution(int[] numbers) {
		int len = numbers.length;
		int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
			answer[i] = -1;
		}
        
		Stack<Integer> stack = new Stack<>();
		for (int i = len - 1; i >= 0; i--) {
			int num = numbers[i];
			while (!stack.isEmpty() && num >= stack.peek()) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				answer[i] = stack.peek();
			}
			stack.add(num);
		}
		return answer;
	}
}