import java.util.*;

class Solution {
	boolean solution(String s) {
		boolean answer = true;
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '(') {
				stack.push(0);
			}
			if(s.charAt(i) == ')') {
				if(stack.isEmpty()) {
					answer = false;
					break;
				}
				stack.pop();
			}
		}
		
		if(!stack.isEmpty()) {
			answer = false;
		}
		
		return answer;
	}
}
