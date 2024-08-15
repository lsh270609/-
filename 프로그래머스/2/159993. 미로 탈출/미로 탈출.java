import java.util.*;

class Solution {
    public int maxRow;
    public int maxCol;
    public char[][] mapArray;

    public int solution(String[] maps) {
        int startRow = -1, startCol = -1;
        int leverRow = -1, leverCol = -1;
        maxRow = maps.length;
        maxCol = maps[0].length();
        mapArray = new char[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            char[] arr = maps[i].toCharArray();
            for (int j = 0; j < maxCol; j++) {
                char c = arr[j];
                mapArray[i][j] = c;
                if (c == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (c == 'L') {
                    leverRow = i;
                    leverCol = j;
                }
            }
        }
        boolean[][] flag = new boolean[maxRow][maxCol];

        int dist1 = bfs(startRow, startCol, flag, 'L');
        if (dist1 == -1) return -1;
        flag = new boolean[maxRow][maxCol];
        int dist2 = bfs(leverRow, leverCol, flag, 'E');
        if (dist2 == -1) return -1;
        else return dist1 + dist2;
    }

    public int bfs(int startRow, int startCol, boolean[][] flag, char target) {
        Queue<Integer> queue = new LinkedList<>();
        flag[startRow][startCol] = true;
        queue.offer(startRow);
        queue.offer(startCol);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            int dist = queue.poll();

            for (int i = 0; i < 4; i++) {
                int d = 1;
                int r = row, c = col;
                if (i % 2 == 1) d *= -1;
                if (i < 2) r += d;
                else c += d;

                if (!outOfRange(r, c) && !flag[r][c] && mapArray[r][c] != 'X') {
                    if (mapArray[r][c] == target) return dist + 1;
                    flag[r][c] = true;
                    queue.offer(r);
                    queue.offer(c);
                    queue.offer(dist + 1);
                }
            }
        }

        return -1;
    }

    public boolean outOfRange(int row, int col) {
        if ((row < 0 || maxRow <= row) || (col < 0 || maxCol <= col)) return true;
        return false;
    }
}