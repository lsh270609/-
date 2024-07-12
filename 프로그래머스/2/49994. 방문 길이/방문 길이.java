class Solution {
	public int solution(String dirs) {
		int x = 5, y = 5, answer = 0;
		// R : 0, L : 1, D : 2, U : 3
		boolean[][][] flag = new boolean[11][11][4];
		for (int i = 0; i < 11; i++) {
			flag[10][i][0] = true;
			flag[0][i][1] = true;
			flag[i][0][2] = true;
			flag[i][10][3] = true;
		}

		for (String str : dirs.split("")) {
			switch (str) {
			case "R":
				if (x == 10) continue;
				if (!flag[x][y][0]) {
					answer += 1;
					flag[x][y][0] = true;
					flag[x + 1][y][1] = true;
				}
				x++;
				break;
			case "L":
				if (x == 0) continue;
				if (!flag[x][y][1]) {
					answer += 1;
					flag[x][y][1] = true;
					flag[x - 1][y][0] = true;
				}
				x--;
				break;
			case "D":
				if (y == 0) continue;
				if (!flag[x][y][2]) {
					answer += 1;
					flag[x][y][2] = true;
					flag[x][y - 1][3] = true;
				}
				y--;
				break;
			case "U":
				if (y == 10) continue;
				if (!flag[x][y][3]) {
					answer += 1;
					flag[x][y][3] = true;
					flag[x][y + 1][2] = true;
				}
				y++;
				break;
			}
		}

		return answer;
	}
}