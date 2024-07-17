import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length() - 2).split("\\}\\,\\{");

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (String str1 : arr) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (String str2 : str1.split(",")) {
                tmpList.add(Integer.parseInt(str2));
            }
            list.add(tmpList);
        }
        list.sort((a, b) -> {return a.size() - b.size();});

        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[list.size()];
        int idx = 0;
        for (ArrayList<Integer> ans : list) {
            for (int i : ans) {
                int size = set.size();
                set.add(i);
                if(size != set.size()) {
                    answer[idx] = i;
                    idx++;
                }
            }
        }
        
        return answer;
    }
}