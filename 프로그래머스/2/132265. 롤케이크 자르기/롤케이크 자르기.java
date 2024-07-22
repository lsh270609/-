import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
		for(int i : topping) {
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}
		
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for(int i : topping) {
			map2.put(i, map2.getOrDefault(i, 0) + 1);
			if(map1.containsKey(i)) {
				map1.put(i, map1.get(i) - 1);
				if(map1.get(i) == 0) map1.remove(i);
			}
			if(map2.size() == map1.size()) answer++;
		}
		return answer;
    }
}