import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int person = 1;
        int idx = 1;
        HashSet<String> givenWords = new HashSet<>();
        boolean flag = true;

        String word = words[0];
        int len = word.length();
        String last = word.substring(len - 1, len);

        givenWords.add(word);
        int arrSize = givenWords.size();

        for (int i = 1; i < words.length; i++) {
            idx++;
            person++;

            word = words[i];
            len = word.length();
            String first = word.substring(0, 1);
            if (!last.equals(first)) {
                flag = false;
                break;
            }
            last = word.substring(len - 1, len);
            givenWords.add(word);
            if(givenWords.size() == arrSize){
                flag = false;
                break;
            }
            arrSize = givenWords.size();
            if (person == n) {
                person = 0;
            }
        }
        answer[0] = person;
        answer[1] = (idx - person) / n + 1;
        if (flag) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}