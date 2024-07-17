import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> reqDaysArr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int reqDays = (int) Math.ceil(((100 - progresses[i]) / (float) speeds[i]));
            reqDaysArr.add(reqDays);
        }
        for (int i = 0; i < reqDaysArr.size();) {
            int a = 1;
            int reqDays = reqDaysArr.get(i);
            for (int j = i + 1; j < reqDaysArr.size(); j++) {
                if (reqDaysArr.get(j) <= reqDays) a++;
                else break;
            }
            ans.add(a);
            i += a;
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}