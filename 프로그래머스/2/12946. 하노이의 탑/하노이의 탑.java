class Solution {
    public int[][] answer;
    public int idx = 0;
    public int[][] solution(int n) {
        int num = (int) Math.pow(2, n) - 1;
        answer = new int[num][2];
        Hanoi(n, 1, 2, 3);
        return answer;
    }
    
    public void Hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            answer[idx++] = new int[]{from, to};
        } else {
            Hanoi(n - 1, from, to, via);
            answer[idx++] = new int[]{from, to};
            Hanoi(n - 1, via, from, to);
        }
    }
}