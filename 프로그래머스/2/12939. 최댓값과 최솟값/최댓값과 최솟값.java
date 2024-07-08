class Solution {
    public String solution(String s) {
	String tmpArr[] = s.split(" ");
	int tmp0 = Integer.parseInt(tmpArr[0]);
	int min = tmp0, max = tmp0, tmp1;
	for(String num : tmpArr) {
		tmp1 = Integer.parseInt(num);
		if(min > tmp1) min = tmp1;
		else if(max < tmp1) max = tmp1;
	}
	String answer = min + " " + max;
	return answer;	
    }
}
