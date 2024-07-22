class Solution {
    int solution(int[][] land) {
        int answer = 0, row = land.length, column = land[0].length;
        int[][] ansArr1 = new int[row + 1][column];
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < column; k++) {
                    if (k == j) continue;
                    ansArr1[i][j] = Math.max(ansArr1[i][j], land[i - 1][j] + ansArr1[i - 1][k]);
                    answer = Math.max(answer, ansArr1[i][j]);
                }
            }
        }

        return answer;
    }
}