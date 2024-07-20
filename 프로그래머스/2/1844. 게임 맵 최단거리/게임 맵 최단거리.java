import java.util.*;

class Solution {
    public int answer;
    public int[][] maps;
    public int length;
    public int width;
    public int val;

    public int solution(int[][] maps) {
        this.maps = maps;
        length = maps.length;
        width = maps[0].length;
        val = length * width + 1;
        answer = val;

        bfs(0, 0);
        return answer == val ? -1 : answer;
    }

    public void bfs(int a, int b) {
        maps[a][b] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        queue.offer(b);
        queue.offer(1);

        while (queue.size() != 0) {
            int x = queue.poll(), y = queue.poll(), dist = queue.poll();
            if (x == length - 1 && y == width - 1) {
                answer = dist;
                break;
            }

            int[][] adj = { { x + 1, y }, { x - 1, y }, { x, y + 1 }, { x, y - 1 } };
            for (int[] tmp : adj) {
                int x0 = tmp[0], y0 = tmp[1];
                if ((x0 >= 0 && x0 < length) && (y0 >= 0 && y0 < width) && maps[x0][y0] != 0) {
                    maps[x0][y0] = 0;
                    queue.offer(x0);
                    queue.offer(y0);
                    queue.offer(dist + 1);
                }
            }
        }
    }
}