import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int timeCnt = 0;
        int atcCnt = 0;
        
        for (int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            timeCnt++;
            if (i == attacks[atcCnt][0]) {
                answer -= attacks[atcCnt][1];
                if(answer <= 0) return -1;
                atcCnt++;
                timeCnt = 0;
                continue;
            }
            if (answer + bandage[1] <= health) {
                answer += bandage[1];
            } else answer = health;
            if (timeCnt == bandage[0]) {
                if (answer + bandage[2] <= health) {
                    answer += bandage[2];
                } else answer = health;
                timeCnt = 0;
            }
        }

        return answer;
    }
}