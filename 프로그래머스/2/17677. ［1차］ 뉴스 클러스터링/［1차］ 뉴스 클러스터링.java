import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> list1 = split(str1);
        ArrayList<String> list2 = split(str2);

        return jaccardIndex(list1, list2);
    }

    public ArrayList<String> split(String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            boolean flag = true;
            String s1 = str.substring(i, i + 2);
            for (String s : s1.split("")) {
                int c = (int) s.charAt(0);
                if ('a' > c || 'z' < c) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(s1);
            }
        }
        return list;
    }

    public int jaccardIndex(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> d1 = new ArrayList<>(list1);
        ArrayList<String> d2 = new ArrayList<>(list2);
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> sum = new ArrayList<>();
        sum.addAll(list1);
        sum.addAll(list2);
        for(String s1 : list1) {
            if(d1.contains(s1) && d2.contains(s1)) {
                intersection.add(s1);
                d1.remove(s1);
                d2.remove(s1);
            }
        }
        for(String s1 : intersection) {
            sum.remove(s1);
        }

        int len1 = intersection.size();
        int len2 = sum.size();
        if(len2 == 0) return 65536;
        return (int) Math.floor(len1 * 1.0 / len2 * 65536);
    }
}