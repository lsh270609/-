import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, cnt = 0;
        HashMap<Integer, Integer> tanCnt = new HashMap<>();
        for (int t : tangerine) {
            tanCnt.put(t, tanCnt.getOrDefault(t, 0) + 1);
        }

        ArrayList<Integer> sortedTan = new ArrayList<>(tanCnt.values());
        sortedTan.sort(Collections.reverseOrder());
        for(int i : sortedTan){
            answer++;
            cnt += i;
            if(cnt >= k) break;
        }
        return answer;
    }
}