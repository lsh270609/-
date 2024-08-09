import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        if (arrayA[0] == 1 && arrayB[0] == 1) return 0;
        int intA = crossCheck(arrayA, arrayB);
        int intB = crossCheck(arrayB, arrayA);
        
        return intA == 0 && intB == 0 ? 0 : Math.max(intA, intB);
    }
    
    public int crossCheck(int[] array1, int[] array2) {
        int gcd1 = gcd(array1);
        if (gcd1 == 0) return 0;
        for (int i : array2) {
            if (i % gcd1 == 0) return 0;
        }
        
        return gcd1;
    }
    
    public int gcd(int[] array) {
        ArrayList<Integer> divArr = divisor(array[0]);
        for (int i = divArr.size() - 1; i >= 0; i--) {
            int divisor = divArr.get(i);
            boolean flag = divisible(array, divisor);
            if (flag) return divisor;
        }
        
        return 0;
    }
    
    public boolean divisible(int[] array, int num) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] % num != 0) return false;
        }
        
        return true;
    }
    
    public ArrayList<Integer> divisor(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num < 4) {
            for (int i = 2; i < num; i++) {
                list.add(i);
            }
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) list.add(i);
            }
            list.add(num);
        }
        
        return list;
    }
}