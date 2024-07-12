class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        return count(n, a, b, answer);
    }

    public int count(int n, int a, int b, int answer) {
        answer++;
        int x;
        if(a % 2 == 0) x = a - 1;
        else x = a + 1;
        if(x == b) return answer;
        return count(n / 2, (int) Math.round(a / 2.0), (int) Math.round(b / 2.0), answer);
    }
}