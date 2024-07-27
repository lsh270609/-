import java.util.*;

class Solution {
    public HashSet<Integer> set;

    public int solution(String numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String str : numbers.split("")) {
            list.add(Integer.parseInt(str));
        }
        set = new HashSet<>();
        HashSet<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            numberSet.add(i);
            bfs(list.get(i), list, numberSet);
            numberSet.remove(i);
        }

        return set.size();
    }

    public void bfs(int num, ArrayList<Integer> list, HashSet<Integer> numberSet) {
        if (primeCheck(num)) set.add(num);
        for (int j = 0; j < list.size(); j++) {
            if (numberSet.contains(j)) continue;
            numberSet.add(j);
            bfs(num * 10 + list.get(j), list, numberSet);
            numberSet.remove(j);
        }
    }

    public boolean primeCheck(int i) {
        if (i < 2) return false;
        for(int j = 2; j <= (int) Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}