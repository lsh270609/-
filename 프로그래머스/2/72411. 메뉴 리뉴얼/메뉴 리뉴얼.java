import java.util.*;

class Solution {
    public HashMap<String, Integer> map = new HashMap<>();
    public int max = 0;
    
    public String[] solution(String[] orders, int[] course) {
        for (int i : course) {
            if (i > max) max = i;
        }
        
        for (String order : orders) {
            String[] arr = order.split("");
            Arrays.sort(arr);
            int len = order.length();
            boolean[] flag = new boolean[len];
            for (int i = 0; i < len; i++) {
                flag[i] = true;
                Combination(arr[i], len, i + 1, 1, arr, flag, course);
                flag[i] = false;
            }
        }
        
        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        class SortMap implements Comparator<Map.Entry<String, Integer>> {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                String key1 = o1.getKey(), key2 = o2.getKey();
                int value1 = o1.getValue(), value2 = o2.getValue();
                if (key1.length() == key2.length()) {
                    return value2 - value1;
                } else return o1.getKey().length() - o2.getKey().length();
                
            }
        }
        Collections.sort(list, new SortMap());
        ArrayList<String> answerList = new ArrayList<>();
        int len = 0, cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            String key = entry.getKey();
            int value = entry.getValue();
            if (key.length() != len && value > 1) {
                len = key.length();
                cnt = value;
                answerList.add(key);
            } else if (value == cnt) {
                answerList.add(key);
            }
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public void Combination(String str, int len, int idx, int cnt, String[] arr, boolean[] flag, int[] course) {
        if (cnt <= max) {
            if (CourseCheck(course, cnt)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            for (int i = idx; i < len; i++) {
                if (flag[i]) continue;
                flag[i] = true;
                Combination(str + arr[i], len, i, cnt + 1, arr, flag, course);
                flag[i] = false;
            }
        }
    }
    
    public boolean CourseCheck(int[] course, int cnt) {
        for (int i : course) {
            if (cnt == i) return true;
        }
        return false;
    }
}