import java.util.*;

class Solution {
    public int cpCol;
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        cpCol = --col;
        int row = data.length, column = data[0].length;
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[cpCol] == o2[cpCol] ? o2[0] - o1[0] : o1[cpCol] - o2[cpCol];
            }
        });
        
        int idx = 0;
        int answer = 0;
        int[] hashArr = new int[row_end - row_begin + 1];
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            for (int j = 0; j < column; j++) {
                hashArr[idx] += data[i][j] % (i + 1);
            }
            answer = answer ^ hashArr[idx++];
        }
        
        return answer;
    }
}