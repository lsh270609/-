class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = sequence.length, range = len + 1;
        int start = 0, end = 0, sum = 0;
        while (start < len && end <= len) {
            if (sum == k) {
                if (range > end - start) {
                    range = end - start;
                    answer[0] = start;
                    answer[1] = end - 1;
                }                
                sum -= sequence[start++];
            } else if (sum > k) {
                sum -= sequence[start++];
            } else {
                if (end < len) {
                    sum += sequence[end++];    
                } else {
                    sum -= sequence[start++];
                }
            }
        }

        return answer;
    }
}