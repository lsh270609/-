class Solution {
    public int solution(int n) {
        if (n == 1) return 1;
		else if (n == 2) return 2;
		else {
			long[] fn = new long[n + 1];
			fn[1] = 1;
			fn[2] = 2;
			for (int i = 3; i <= n; i++) {
				fn[i] = (fn[i - 2] + fn[i - 1]) % 1000000007;
			}
			return (int) fn[n];
		}
    }
}