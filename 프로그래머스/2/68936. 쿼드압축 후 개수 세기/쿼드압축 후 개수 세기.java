import java.util.*;

class Solution {
    public int cnt0 = 0;
    public int cnt1 = 0;
    public int n;
    
    public int[] solution(int[][] arr) {
        
        int len = arr.length;
        n = (int) (Math.log10(len) / Math.log10(2)) + 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // x;
        queue.offer(0); // y;
        queue.offer(1); // depth;
        
        while (!queue.isEmpty()) {
			int x = queue.poll(), y = queue.poll(), depth = queue.poll();
			if (depth < n) {
				boolean flag1 = false;
				int flag = arr[x][y];
				int d = len / (int) Math.pow(2, depth - 1);
				for (int i = x; i < x + d; i++) {
					for (int j = y; j < y + d; j++) {
						if (arr[i][j] != flag) {
							flag1 = true;
							break;
						}
					}
				}
				if (flag1) {
					d = len / (int) Math.pow(2, depth);
					int ox, oy;
					for (int i = 1; i <= 4; i++) {
						if (i % 2 == 0) ox = x;
						else ox = x + d;
						if(i > 2) oy = y + d;
						else oy = y;
						queue.offer(ox);
						queue.offer(oy);
						queue.offer(depth + 1);
					}
				} else {
					if (flag == 0) cnt0 += 1;
					else cnt1 += 1;
				}
			} else {
				if (arr[x][y] == 0) cnt0 += 1;
				else cnt1 += 1;
			}

		}
        
        int[] answer = new int[2];
        answer[0] = cnt0;
        answer[1] = cnt1;
        
        return answer;
    }
}