import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(priorities[i]);
            list.add(i == location ? 1 : 0);
            queue.offer(list);
        }

        Arrays.sort(priorities);
        int len = priorities.length;
        int idx = 0;
        while (queue.size() > 0) {
            ArrayList<Integer> list = queue.poll();
            if (list.get(0) == priorities[len - 1 - idx]) {
                if(list.get(1) == 1) return idx + 1;
                else idx++;
            } else {
                queue.offer(list);
            }
        }

        return -1;
    }
}