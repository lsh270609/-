import java.util.*;

class Solution {
    public char[][] boardArr;
    public boolean[][] flag;
    
    public int solution(String[] board) {
        int startRow = -1, startCol = -1;
        int maxRow = board.length, maxCol = board[0].length();
        boardArr = new char[maxRow][maxCol];
        flag = new boolean[maxRow][maxCol];
        
        for (int i = 0; i < maxRow; i++) {
            char[] arr = board[i].toCharArray();
            for (int j = 0; j < maxCol; j++) {
                boardArr[i][j] = arr[j];
                if (arr[j] == 'R') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startRow);
        queue.offer(startCol);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            int cnt = queue.poll();
            if (flag[row][col]) continue;
            flag[row][col] = true;
            
            if (boardArr[row][col] == 'G') return cnt;
            
            int cpRow = row;
            while (cpRow > 0 && boardArr[cpRow - 1][col] != 'D') {
                cpRow--;
            }
            if (cpRow != row) {
                queue.offer(cpRow);
                queue.offer(col);
                queue.offer(cnt + 1);
            }
            cpRow = row;
            while (cpRow < maxRow - 1 && boardArr[cpRow + 1][col] != 'D') {
                cpRow++;
            }
            if (cpRow != row) {
                queue.offer(cpRow);
                queue.offer(col);
                queue.offer(cnt + 1);
            }
            int cpCol = col;
            while (cpCol > 0 && boardArr[row][cpCol - 1] != 'D') {
                cpCol--;
            }
            if (cpCol != col) {
                queue.offer(row);
                queue.offer(cpCol);
                queue.offer(cnt + 1);
            }
            cpCol = col;
            while (cpCol < maxCol - 1 && boardArr[row][cpCol + 1] != 'D') {
                cpCol++;
            }
            if (cpCol != col) {
                queue.offer(row);
                queue.offer(cpCol);
                queue.offer(cnt + 1);
            }
        }
        
        return -1;
    }
}