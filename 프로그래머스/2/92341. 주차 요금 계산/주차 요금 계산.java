import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<String> recordList = new ArrayList<>(Arrays.asList(records));
        HashMap<String, Integer> count = new HashMap<>();
        for(String record : records) {
            count.put(record.substring(6, 10), count.getOrDefault(record, 0) + 1);
        }
        for(String str : count.keySet()) {
            if(count.get(str) % 2 == 1)  recordList.add("23:59 "+str+" OUT");
        }
        System.out.println(recordList.toString());
        HashMap<String, ArrayList<Integer>> map = new HashMap<>(); 
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            tmp.add(0);
        }
        for(String record : recordList) {
            String str = record.substring(6, 10);
            int time = Integer.parseInt(record.substring(0, 2)) * 60 + Integer.parseInt(record.substring(3, 5));
            ArrayList<Integer> list = map.getOrDefault(str, new ArrayList<Integer>(tmp));
            list.set(0, list.get(0) + 1);
            if(list.get(0) % 2 == 0) {
                list.set(1, list.get(1) + time - list.get(2));
            } else {
                list.set(2, time);
            }
            map.put(str, list);
        }

        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
        for(int i = 0; i < keySet.size(); i++) {
            int time = map.get(keySet.get(i)).get(1);
            if(time > fees[0]) {
                answer[i] = fees[1] + (int) Math.ceil((time - fees[0]) * 1.0 / fees[2]) * fees[3];
            } else {
                answer[i] = fees[1];
            }
        }
        return answer;
    }
}