import java.util.*;

class Solution {
    public final int md = 3;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            char[][] place = new char[5][5];
            int[] row = new int[25];
            int[] col = new int[25];
            int rIdx = 0, cIdx = 0;
            for (int j = 0; j < 5; j++) {
                place[j] = places[i][j].toCharArray();
                for (int k = 0; k < 5; k++) {
                    if (place[j][k] =='P') {
                        row[rIdx++] = j;
                        col[cIdx++] = k;
                    }
                }
            }
            
            boolean flag = false;
            for (int j = 0; j < rIdx; j++) {
                for (int k = j + 1; k < rIdx; k++) {
                    int r1 = row[j], r2 = row[k];
                    int c1 = col[j], c2 = col[k];
                    if (!outOfRange(r1, c1, r2, c2) && connected(r1, c1, r2, c2, place)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (!flag) answer[i] = 1;
        }
        
        return answer;
    }
    
    public boolean connected(int r1, int c1, int r2, int c2, char[][] place) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r1);
        queue.offer(c1);
        boolean br = false, bc = false;
        int dr = 0, dc = 0;
        if (r1 < r2) dr = 1;
        else if (r1 < r2) dr = -1;
        else br = true;
        if (c1 < c2) dc = 1;
        else if (c1 > c2) dc = -1;
        else bc = true;
        
        while (!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            if (place[row][col] == 'X') continue;
            if (row == r2 && col == c2) return true;
            for (int i = 0; i < 2; i++) {
                int r = row, c = col;
                boolean b = false;
                if (i < 1) {
                    r += dr;
                    b = br;
                } else {
                    c += dc;
                    b = bc;
                }
                if (!b && !outOfRange(r, c, r2, c2)) {
                    queue.offer(r);
                    queue.offer(c);
                }
            }
        }
        
        return false;
    }
    
    public boolean outOfRange(int r1, int c1, int r2, int c2) {
        if (r1 < 0 || 5 <= r1 || c1 < 0 || 5 <= c1) return true;
        if (Math.abs(r1 - r2) + Math.abs(c1 - c2) < md) return false;
        return true;
    }
}