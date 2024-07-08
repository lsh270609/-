class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int openCnt = 0, closeCnt = 0;
        
        for (int i = 0; i < s.length(); i++ ) {
        	if(s.charAt(i) == '(') {
        		openCnt++;
        	} else if(s.charAt(i) == ')') {
        		closeCnt++;
        	}
        	if(openCnt < closeCnt) {
        		answer = false;
        		break;
        	}
        }
        
        if(!(openCnt == closeCnt)) {
        	answer = false;
        }

        return answer;
    }
}