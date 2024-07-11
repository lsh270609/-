import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String curSkill : skill_trees) {
			answer += skillTree(skill, curSkill);
		}

		return answer;
	}

	public int skillTree(String skill, String curSkill) {
		Queue<String> queue1 = new LinkedList<>();
		for (String s : skill.split("")) {
			queue1.offer(s);
		}
		Queue<String> queue2 = new LinkedList<>();
		for (String s : curSkill.split("")) {
			queue2.offer(s);
		}
		for (int i = 0; i < curSkill.length(); i++) {
			if (!skill.contains(queue2.peek())) {
				queue2.poll();
			} else if (queue1.peek().equals(queue2.peek())) {
				queue1.poll();
				queue2.poll();
			} else return 0;
		}
		return 1;
	}
}
