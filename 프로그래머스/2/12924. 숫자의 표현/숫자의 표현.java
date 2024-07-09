class Solution {
    public int solution(int n) {
        int answer = 0;
	int nh = (n != 2) ? (int) Math.round(n / 2.0) : 2;
	int sum = 0;

	for (int i = 1; i <= nh; i++) {
		sum = 0;
		for (int j = i; j <= nh; j++) {
			sum += j;
			if (sum == n) {
				answer++;
				break;
			} else if (sum > n) {
				break;
			}
		}
	}
	if(n == 1 || n == 2) return answer;
	else return answer+1;
    }
}
