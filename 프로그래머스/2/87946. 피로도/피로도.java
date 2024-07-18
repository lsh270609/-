class Solution {
    public int answer = 0;
    public boolean[] flag;

    public int solution(int k, int[][] dungeons) {
        flag = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!flag[i] && dungeons[i][0] <= k) {
                flag[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                flag[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}