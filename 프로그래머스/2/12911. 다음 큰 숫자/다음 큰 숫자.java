class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = Integer.bitCount(n);

        while (true) {
            if (cnt == Integer.bitCount(++n)) break;
        }

        return n;
    }
}