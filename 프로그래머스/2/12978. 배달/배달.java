import java.util.*;

class Solution {
	public int solution(int N, int[][] road, int K) {
        int answer = 1;
		long[][] roadMap = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) roadMap[i][j] = Integer.MAX_VALUE;
            }
        }
        
		for (int[] info : road) {
			int village1 = info[0];
			int village2 = info[1];
			int dist = info[2];
            roadMap[village1][village2] = Math.min(roadMap[village1][village2], dist);
            roadMap[village2][village1] = Math.min(roadMap[village2][village1], dist);
		}
        

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (j != k) roadMap[j][k] = Math.min(roadMap[j][k], roadMap[j][i] + roadMap[i][k]);
                }
            }
        }
        
        for (int i = 2; i <= N; i++) {
            if (roadMap[1][i] <= K) answer++;
        }

		return answer;
	}
}