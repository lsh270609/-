class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = 0;
        for (int i : topping) {
            if (len < i) len = i;
        }
        int[] left = new int[len + 1], right = new int[len + 1];
        
        int ls = 0, rs = 0;
        for (int i : topping) {
            right[i]++;
        }
        for (int i : right) {
            rs += i > 0 ? 1 : 0;
        }
        
        for (int i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        
        return answer;
    }
}
