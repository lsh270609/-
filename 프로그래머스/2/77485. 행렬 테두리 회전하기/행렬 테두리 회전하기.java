import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
		int[][] arr = new int[rows + 1][columns + 1];
		int num = 0;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				num += 1;
				arr[i][j] = num;
			}
		}
        
		ArrayList<Integer> list = new ArrayList<>();
		for (int[] query : queries) {
			int row1 = query[0], col1 = query[1];
			int row2 = query[2], col2 = query[3];
			int min = rows * columns + 1;
			int width = col2 - col1 + 1, length = row2 - row1 + 1;
			int cnt = width * length - (width - 2) * (length - 2);
			int brow = row1, bcol = col1;
			int arow = row1 + 1, acol = col1;
			int tmp = arr[row1][col1];
			while (cnt > 0) {
				arr[brow][bcol] = arr[arow][acol];
				min = Math.min(arr[brow][bcol], min);
				brow = arow;
				bcol = acol;
				if (acol == col1 && arow != row2) arow++;
				else if (acol != col2 && arow == row2) acol++;
				else if (acol == col2 && arow != row1) arow--;
				else if (acol != col1 && arow == row1) acol--;
				cnt--;
			}
			arr[row1][col1 + 1] = tmp;
			min = Math.min(tmp, min);
			list.add(min);
		}
        
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}