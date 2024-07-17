import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for (String s : cities) {
            s = s.toLowerCase();
            boolean flag = queue.size() == cacheSize;
            if (queue.contains(s)) {
                queue.remove(s);
                queue.offer(s);
                answer += 1;
            } else {
                queue.offer(s);
                if (flag) queue.poll();
                answer += 5;
            }
        }
        return answer;
    }
}