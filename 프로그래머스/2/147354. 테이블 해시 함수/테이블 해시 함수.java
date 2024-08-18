import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int row = data.length, column = data[0].length;
        col--;
        for (int i = 0; i < row; i++) {
            int[] t1 = data[i];
            for (int j = i + 1; j < row; j++) {
                int[] t2 = data[j];
                if (t1[col] > t2[col]) {
                    swap(t1, t2);
                } else if (t1[col] == t2[col]) {
                    if (t1[0] < t2[0]) {
                        swap(t1, t2);
                    }
                }
            }
        }
        
        int idx = 0;
        int[] hashArr = new int[row_end - row_begin + 1];
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            for (int j = 0; j < column; j++) {
                hashArr[idx] += data[i][j] % (i + 1);
            }
            idx++;
        }
        
        int answer = hashArr[0];
        for (int i = 1; i < hashArr.length; i++) {
            answer = answer ^ hashArr[i];
        }
        
        return answer;
    }
    
    public void swap(int[] arr1, int[] arr2) {
        int[] cpArr = copy(arr2);
        for (int k = 0; k < arr1.length; k++) {
            arr2[k] = arr1[k];
            arr1[k] = cpArr[k];
        }
    }
    
    public int[] copy(int[] arr) {
        int[] cpArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cpArr[i] = arr[i];
        }
        return cpArr;
    }
}