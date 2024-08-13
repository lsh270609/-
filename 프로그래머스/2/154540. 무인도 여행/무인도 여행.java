import java.util.*;

class Solution {
    public ArrayList<Integer> list;
    public int[][] arr;
    public boolean[][] flag;
    public int row;
    public int col;
    public int sum;
    
    public int[] solution(String[] maps) {
        int[] answer;
        row = maps.length;
        col = maps[0].length();
        arr = new int[row][col];
        flag = new boolean[row][col];
        boolean allBlue = true;
        for (int i = 0; i < row; i++) {
            String[] tmp = maps[i].split("");
            for (int j = 0; j < col; j++) {
                if (!tmp[j].equals("X")) {
                    allBlue = false;
                    arr[i][j] = Integer.parseInt(tmp[j]);
                } else arr[i][j] = 0;
            }
        }
        
        if (allBlue) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (flag[i][j] || arr[i][j] == 0) continue;
                list.add(add(i, j));
            }
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int add(int currentRow, int currentCol) {
        sum = arr[currentRow][currentCol];
        flag[currentRow][currentCol] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentRow);
        queue.offer(currentCol);
        while (!queue.isEmpty()) {
            int R = queue.poll();
            int C = queue.poll();
            queue = offer(queue, R + 1, C);
            queue = offer(queue, R - 1, C);
            queue = offer(queue, R, C + 1);
            queue = offer(queue, R, C - 1);
        }
        
        return sum;
    }
    
    public Queue<Integer> offer(Queue<Integer> queue, int R, int C) {
        if (!outOfRange(R, C) && isNotIsland(R, C) && !flag[R][C]) {
            flag[R][C] = true;
            sum += arr[R][C];
            queue.offer(R);
            queue.offer(C);
        }
        return queue;
    }
    
    public boolean outOfRange(int R, int C) {
        if ((R < 0 || row <= R) || (C < 0 || col <= C)) return true;
        return false;
    }
    
    public boolean isNotIsland(int R, int C) {
        if (arr[R][C] == 0) return false;
        return true;
    }
}