class Solution {
    public int solution(int n) {
        String toStr = Integer.toBinaryString(n);
        int cnt = toStr.length() - toStr.replace("1", "").length();

        while (true) {
            n++;
            toStr = Integer.toBinaryString(n);
            int cnt1 = toStr.length() - toStr.replace("1", "").length();
            if (cnt == cnt1) break;
        }

        return n;
    }
}