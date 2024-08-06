import java.util.*;

class Solution {
    public HashMap<Integer, ArrayList<Integer>> map;

    public int solution(int n, int[][] wires) {
        int answer = n;

        map = new HashMap<>();

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            map.put(v1, map.getOrDefault(v1, new ArrayList<>()));
            map.get(v1).add(v2);
            map.put(v2, map.getOrDefault(v2, new ArrayList<>()));
            map.get(v2).add(v1);
        }

        for (int i =0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            boolean[] visited = new boolean[n + 1];

            map.get(v1).remove(Integer.valueOf(v2));
            map.get(v2).remove(Integer.valueOf(v1));

            int cnt = dfs(v1, visited);
            int d = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, d);

            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        return answer;
    }

    public int dfs(int i, boolean[] visited) {
        visited[i] = true;
        int cnt = 1;

        for (int nextV : map.get(i)) {
            if(!visited[nextV]) {
                cnt += dfs(nextV, visited);
            }
        }
        return cnt;
    }
}