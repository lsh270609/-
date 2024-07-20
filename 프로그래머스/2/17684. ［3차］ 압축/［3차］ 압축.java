import java.util.*;

class Solution {
    public ArrayList<Integer> ansList = new ArrayList<>();
    public ArrayList<String> list = new ArrayList<>();

    public int[] solution(String msg) {
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char) ('A' + i)));
        }

        while(msg.length() > 0) {
            msg = subStr(msg, 1);
        }

        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }

    public String subStr(String msg, int idx) {
        String str1 = msg.substring(0, idx);
        if(msg.length() == idx) {
            ansList.add(list.indexOf(str1) + 1);
            return "";
        }
        String str2 = msg.substring(0, idx + 1);
        if(list.contains(str1) && !list.contains(str2)){
            ansList.add(list.indexOf(str1) + 1);
            list.add(str2);
            return msg.substring(idx);
        } else return subStr(msg, idx + 1);
    }
}