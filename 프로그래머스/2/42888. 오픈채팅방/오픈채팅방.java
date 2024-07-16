import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (String str : record) {
            String[] arr = str.split(" ");
            switch (arr[0]) {
                case "Enter":
                    result.add(arr[1] + " 1");
                    map.put(arr[1], arr[2]);
                    break;
                case "Leave":
                    result.add(arr[1] + " 0");
                    break;
                case "Change":
                    map.put(arr[1], arr[2]);
                    break;
            }
        }
        
        int len = result.size();
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            String[] arr = result.get(i).split(" ");
            answer[i] = map.get(arr[0]) + (arr[1].equals("1") ? "님이 들어왔습니다." : "님이 나갔습니다.");
        }

        return answer;
    }
}