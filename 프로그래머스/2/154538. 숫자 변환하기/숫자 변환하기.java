import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }

    public int bfs(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(y);
        queue.offer(0);

        while (!queue.isEmpty()) {
            y = queue.poll();
            int cnt = queue.poll();
            if (x == y) return cnt;
            if (y % 3 == 0 && y / 3 >= x) {
                queue.offer(y / 3);
                queue.offer(cnt + 1);
            }
            if (y % 2 == 0 && y / 2 >= x) {
                queue.offer(y / 2);
                queue.offer(cnt + 1);
            }
            if (y - n >= x) {
                queue.offer(y - n);
                queue.offer(cnt + 1);
            }
        }
        return -1;
    }
}