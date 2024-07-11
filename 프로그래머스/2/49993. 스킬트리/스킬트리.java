import java.util.*;

class Solution {
    public int solution(String order, String[] skill_trees) {
        int answer = 0;
        
        for(String skill : skill_trees) {
            answer += skillTree(order, skill);
        }
        
        return answer;
    }
    
    public int skillTree(String order, String skill) {
        Queue<String> queue1 = new LinkedList<>();
        for(String s : order.split("")) {
            queue1.offer(s);
        }
        Queue<String> queue2 = new LinkedList<>();
        for(String s : skill.split("")) {
            queue2.offer(s);
        }
        for(int i = 0; i < skill.length(); i++) {
            if(!order.contains(queue2.peek())) {
                queue2.poll();
            } else if (queue1.peek().equals(queue2.peek())) {
                queue1.poll();
                queue2.poll();
            } else {
                return 0;
            }
        }
        return 1;
    }
}