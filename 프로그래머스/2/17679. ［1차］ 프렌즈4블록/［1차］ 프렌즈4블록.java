import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
		int answer = 0;
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		String[][] arr1 = new String[m][n];
		for (int i = 0; i < m; i++) {
			String[] arr2 = board[i].split("");
			for (int j = 0; j < n; j++) {
				arr1[i][j] = arr2[j];
			}
		}

		while (true) {
			set.clear();
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					String x1 = arr1[i][j], y1 = arr1[i][j + 1];
					String x2 = arr1[i + 1][j], y2 = arr1[i + 1][j + 1];
					if (x1.equals("0")) continue;
					else if (x1.equals(y1) && x1.equals(x2) && y1.equals(y2)) {
						set.add(new ArrayList<Integer>(List.of(i, j)));
						set.add(new ArrayList<Integer>(List.of(i, j + 1)));
						set.add(new ArrayList<Integer>(List.of(i + 1, j)));
						set.add(new ArrayList<Integer>(List.of(i + 1, j + 1)));
					}
				}
			}
			if (set.isEmpty()) break;
			else answer += set.size();
            
			for (int i = 0; i < n; i++) {
				ArrayList<String> list = new ArrayList<>();
				for (int j = m - 1; j >= 0; j--) {
					if (!set.contains(new ArrayList<Integer>(List.of(j, i)))) {
						list.add(arr1[j][i]);
					}
				}
				Iterator<String> it = list.iterator();
				int k = 0;
				while (it.hasNext()) {
					arr1[m - 1 - k++][i] = it.next();
				}
				for (int j = m - k - 1; j >= 0; j--) {
					arr1[j][i] = "0";
				}
			}
		}
        
		return answer;
	}
}