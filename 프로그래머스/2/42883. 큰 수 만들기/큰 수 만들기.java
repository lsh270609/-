import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int n = len - k;
        int[] arr = new int[len];
        String[] tmp = number.split("");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int baseIdx = 0;
        for (int i = 1; i <= n; i++) {
            int maxIdx = baseIdx;
            for (int j = baseIdx; j < len - (n - i); j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            answer.append(arr[maxIdx]);
            baseIdx = maxIdx + 1;
        }

        return answer.toString();
    }
}