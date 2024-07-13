import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, HashMap<String, Integer>> record = new HashMap<>();
        HashMap<String, Integer> points = new HashMap<>();
        HashMap<String, Integer> nextMonthGift = new HashMap<>();

        for(String str : friends) {
            record.put(str, new HashMap<>());
            points.put(str, 0);
            nextMonthGift.put(str, 0);
        }

        for(String str : gifts) {
            String[] tmp = str.split(" ");
            String give = tmp[0];
            String take = tmp[1];

            record.get(give).put(take, record.get(give).getOrDefault(take, 0) + 1);

            points.put(give, points.get(give) + 1);
            points.put(take, points.get(take) - 1);
        }

        for(String str1 : friends) {
            for(String str2 : friends) {
                if(str1.equals(str2)) continue;
                int i = record.get(str1).getOrDefault(str2, 0);
                int j = record.get(str2).getOrDefault(str1, 0);
                if(i > j) nextMonthGift.put(str1, nextMonthGift.get(str1) + 1);
                else if(i - j == 0) {
                    int x = points.get(str1) - points.get(str2);
                    if(x > 0) nextMonthGift.put(str1, nextMonthGift.get(str1) + 1);
                }
            }
        }

        return Collections.max(nextMonthGift.values());
    }
}