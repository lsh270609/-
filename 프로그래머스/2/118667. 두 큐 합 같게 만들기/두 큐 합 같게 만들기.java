import java.util.*;

class Solution {    
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for (int i : queue1) {
            q1.offer(i);
            sum1 += i;
        }
        for (int i : queue2) {
            q2.offer(i);
            sum2 += i;
        }

        for (int i = 0; i < (queue1.length + queue2.length) * 2; i++) {
            if (sum1 > sum2) {
                int x = q1.poll();
                q2.offer(x);
                sum1 -= x;
                sum2 += x;
            } else if (sum1 < sum2) {
                int x = q2.poll();
                q1.offer(x);
                sum2 -= x;
                sum1 += x;
            } else {
                return i;
            }
        }

        return -1;
    }
}