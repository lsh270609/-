import java.math.BigInteger;

class Solution {
	public long solution(int a) {
		BigInteger answer = new BigInteger("0");

		int x = a / 2;
		int n = a;
		int r = 0;
		for (int i = 0; i <= x; i++) {
			BigInteger tmp1 = new BigInteger("1");
			for (int j = n; j > n - r; j--) {
				BigInteger tmp2 = new BigInteger(String.valueOf(j));
				tmp1 = tmp1.multiply(tmp2);
			}
			BigInteger tmp3 = new BigInteger("1");
			for (int j = r; j > 0; j--) {
				BigInteger tmp4 = new BigInteger(String.valueOf(j));
				tmp3 = tmp3.multiply(tmp4);
			}
			answer = answer.add(tmp1.divide(tmp3));
			n--;
			r++;
		}
		
		BigInteger o = new BigInteger("1234567");
		return answer.remainder(o).longValue();
	}
}