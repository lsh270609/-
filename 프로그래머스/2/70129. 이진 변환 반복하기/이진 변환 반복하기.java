class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int tmp;
        while(!s.equals("1")) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            tmp = s.length();
            answer[1] -= tmp;
            s = Integer.toBinaryString(tmp);
            answer[0]++;
        }
        return answer;  
    }
}