import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] arr = {2, 3, 4};
        int furthest = arr.length - 1;
        HashSet<Double> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                set.add(arr[i] * 1.0 / arr[j]);
            }
        }
        
        int len = weights.length;
        Arrays.sort(weights);
        for (int i = 0; i < len; ) {
            int w1 = weights[i];
            int cnt = 1;
            for (int j = i + 1; j < len; j++) {
                if (w1 == weights[j]) cnt++;
                else break;
            }
            
            long tmp = 0;
            for (int j = i + 1; j < len; j++) {
                int w2 = weights[j];
                if (w1 * furthest < w2) break;
                if (set.contains(w1 * 1.0 / w2)) tmp++;
            }
            if (tmp != 0) {
                answer += (tmp + (tmp - cnt + 1)) * cnt / 2;
            }
            i += cnt;
        }
        
        return answer;
    }
}