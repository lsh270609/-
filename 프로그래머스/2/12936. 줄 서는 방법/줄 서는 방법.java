import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long f = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            f *= i;
        }
        
        k--;
        for (int i = 0; i < answer.length; i++) {
            long tmp = f / n;
            answer[i] = list.remove((int) (k / tmp));
            k %= tmp;
            f /= n;
            n--;
        }
        
        return answer;
    }
}