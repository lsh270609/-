class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] arr = new int[n + 1][n];
        int row = 0, col = 0, timing = 0, number = 0;
        int tmpN = n;
        
        while (true) {
            for (int i = 1; i <= tmpN; i++) {
                if (timing % 3 == 0) {
                    arr[++row][col] = number + i;
                } else if ((timing - 1) % 3 == 0) {
                    arr[row][++col] = number + i;
                } else {
                    arr[--row][--col] = number + i;
                }
            }
            number += tmpN;
            timing++;
            if (--tmpN == 0) break;
        }

        int cnt = 0, idx = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= cnt; j++) {
                answer[idx++] = arr[i][j];
            }
            cnt++;
        }

        return answer;
    }
}