class Solution {
    public String solution(int n) {
        String answer = "";
        int num = 16;
        for (int i = 1; i < 16; i++) {
            if (3 * ((int) Math.pow(3, i) - 1) / 2 >= n) {
                num = i - 1;
                break;
            }
        }
        
        for (int i = num; i >= 0; i--) {
            int sum = 3 * ((int) Math.pow(3, i) - 1) / 2;
            if (n < sum) continue;
            int tmp = (n - sum - 1) / (int) Math.pow(3, i);
            if (tmp == 0) {
                answer += "1"; 
            } else if (tmp == 1) {
                answer += "2";
            } else {
                answer += "4";
            }
            n -= (tmp + 1) * (int) Math.pow(3, i);
        }
        return answer;
    }
}