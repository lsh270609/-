import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> mailCnt = new HashMap<>();
        HashMap<String, HashSet<String>> reportedBy = new HashMap<>();
        for(String id : id_list) {
            reportedBy.put(id, new HashSet<String>());
            mailCnt.put(id, 0);
        }
        for(String str : report) {
            String[] tmp = str.split(" ");
            String reporter = tmp[0];
            String troller = tmp[1];

            reportedBy.get(troller).add(reporter);
        }
        for(String id : id_list) {
            if(reportedBy.get(id).size()>=k) {
                for(String s : reportedBy.get(id)) {
                    mailCnt.put(s, mailCnt.get(s)+1);
                }
            }
        }
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            answer[i] = mailCnt.get(id_list[i]);
        }

        return answer;
    }
}