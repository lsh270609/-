import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(list);

        for(int i = 0; i < list.size() - 1; i++) {
            String str1 = list.get(i), str2 = list.get(i + 1);
            if(str1.length() > str2.length()) continue;
            if(str1.equals(str2.substring(0, str1.length()))) {
                return false;
            }
        }

        return true;
    }
}