import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < len; i++) {
            int tmp = citations[len - 1 - i] / (i + 1);
            if (tmp >= 1) answer++;
            else break;
        }

        return answer;
    }
}