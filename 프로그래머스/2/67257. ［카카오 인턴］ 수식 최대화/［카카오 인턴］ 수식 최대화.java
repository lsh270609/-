import java.util.*;

class Solution {
    public ArrayList<Character> opList;
    public ArrayList<Long> number;
    public ArrayList<Character> operator;
    public long max = 0;
    
    public long solution(String expression) {
        char[] charArr = expression.toCharArray();
        number = new ArrayList<>();
        operator = new ArrayList<>();
        HashSet<Character> opSet = new HashSet<>(List.of('+', '-', '*'));
        String str = "";
        for (char c : charArr) {
            if (opSet.contains(c)) {
                number.add(Long.parseLong(str));
                str = "";
                operator.add(c);
            } else {
                str += c;
            }
        }
        number.add(Long.parseLong(str));
        
        opList = new ArrayList<>(new HashSet<Character>(operator));
        int size = opList.size();
        boolean[] flag = new boolean[size];
        for (int i = 0; i < size; i++) {
            flag[i] = true;
            permutation(1, size, flag, new ArrayList<Character>(List.of(opList.get(i))));
            flag[i] = false;
        }
        
        return max;
    }
    
    public void permutation(int start, int end, boolean[] flag, ArrayList<Character> list) {
        if (start == end) {
            // System.out.println(list.toString());
            maxValue(list);
        } else {
            for (int i = 0; i < end; i++) {
                if (flag[i]) continue;
                flag[i] = true;
                list.add(opList.get(i));
                permutation(start + 1, end, flag, list);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
    
    public void maxValue(ArrayList<Character> list) {
        ArrayList<Long> numberList = new ArrayList<>(number);
        ArrayList<Character> operatorList = new ArrayList<>(operator);
        
        for (char c : list) {
            int cnt = 0;
            for (int i = 0; i < operatorList.size(); i++) {
                char op = operatorList.get(i);
                if (op == c) {
                    long num = calc(numberList.get(i - cnt), numberList.get(i + 1 - cnt), op);
                    numberList.remove(i - cnt);
                    numberList.remove(i - cnt);
                    numberList.add(i - cnt, num);
                    cnt++;
                }
            }
            operatorList.removeAll(List.of(c));
        }
        
        max = Math.max(max, Math.abs(numberList.get(0)));
    }
    
    public long calc(long num1, long num2, char c) {
        long num = 0;
        switch(c) {
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
        }
        return num;
    }
}