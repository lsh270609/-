class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        int len = truck_weights.length;
        int[] timeCnt = new int[len];
        timeCnt[0] = bridge_length;

        for (int i = 1; i < len; i++) {
            int sum = truck_weights[i], cnt = 0;
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                if (sum + truck_weights[j] <= weight) {
                    sum += truck_weights[j];
                    cnt++;
                    if (j == 0) flag = true;
                } else break;
            }

            if (flag) timeCnt[i] = 1;
            else {
                int tmp = 0;
                for(int j = 1; j <= cnt; j++) {
                    tmp += timeCnt[i - j];
                }
                timeCnt[i] = tmp >= bridge_length ? 1 : bridge_length - tmp;
            }
            answer += timeCnt[i];
        }

        return answer + 1;
    }
}