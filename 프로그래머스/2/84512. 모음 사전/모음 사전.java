import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;

        String str = "AEIOU";

        ArrayList<Integer> list = new ArrayList<>();
        int len = str.length();
        for(int i = len - 1; i >= 0; i--) {
            int sum = 0;
            for(int j = 0; j <= i; j++) {				
                sum += (int) Math.pow(len, j);
            }
            list.add(sum);
        }

        String[] wordArr = word.split("");
        for(int i = 0; i < wordArr.length; i++) {
            answer += str.indexOf(wordArr[i]) * list.get(i) + 1;
        }

        return answer;
    }
}