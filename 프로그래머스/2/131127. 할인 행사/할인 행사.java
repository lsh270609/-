import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> cntMap = new HashMap<>();
        int cnt = 0;
        for (int i : number) {
            cnt += i;
        }
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (String s : discount) {
            if (map.containsKey(s)) {
                cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
            }
        }
        int cnt2 = 0;
        for (int i : cntMap.values()) {
            cnt2 += i;
        }
        if (cnt > cnt2) return 0;
        else cntMap.clear();

        int len = discount.length - cnt;
        for (int j = 0; j <= len; j++) {
            for(int i = j; i < cnt + j; i++) {
                cntMap.put(discount[i], cntMap.getOrDefault(discount[i], 0) + 1);
            }
            boolean flag = true;
            for(String s : want) {
                if(map.keySet().contains(s)) {
                    int x = map.get(s);
                    int y = cntMap.getOrDefault(s, 0);
                    if(x != y) flag = false;                
                } else flag = false;
            }
            cntMap.clear();
            if (flag) answer++;
        }
        return answer;
    }
}