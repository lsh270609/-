class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];

        for (int i = 0; i < len; i++) {
            long number = numbers[i];

            if (Long.bitCount(number + 1) == 1) {
                answer[i] = number + (long) Math.pow(2, Long.toBinaryString(number).length() - 1);
            } else {
                long tmp = (long) Math.pow(2, Long.toBinaryString(number + 1).length() - 2);
                while (tmp > 2) {
                    if ((number + 1) % tmp == 0) {
                        answer[i] = number + tmp / 2;
                        break;
                    } else {
                        tmp /= 2;
                    }
                }
                if(answer[i] == 0) {
                    answer[i] = number + 1;
                }
            }
        }

        return answer;
    }
}