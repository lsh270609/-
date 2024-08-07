import java.util.*;

class Solution {
    class bookTime {
        private int start;
        private int end;

        public bookTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public int solution(String[][] book_time) {
        ArrayList<bookTime> list = new ArrayList<>();
        for (String[] arr : book_time) {
            int startHour = Integer.parseInt(arr[0].substring(0, 2));
            int startMin = Integer.parseInt(arr[0].substring(3));
            int endHour = Integer.parseInt(arr[1].substring(0, 2));
            int endMin = Integer.parseInt(arr[1].substring(3)) + 10;

            int start = startHour * 100 + startMin;
            int end;
            if (endMin >= 60) {
                end = (endHour + 1) * 100 + (endMin - 60);
            } else {
                end = endHour * 100 + endMin;
            }

            list.add(new bookTime(start, end));
        }

        class timeCompare implements Comparator<bookTime> {
            @Override
            public int compare(bookTime b1, bookTime b2) {
                return b1.getStart() - b2.getStart();
            }
        }
        Collections.sort(list, new timeCompare());

        ArrayList<Integer> endTimeList = new ArrayList<>();
        endTimeList.add(list.get(0).getEnd());
        for (int i = 1; i < list.size(); i++) {
            bookTime bt = list.get(i);
            Iterator<Integer> it = endTimeList.iterator();
            int cnt = 0;
            while (it.hasNext()) {
                int endTime = it.next();
                if (bt.getStart() < endTime) {
                    if (!it.hasNext()) {
                        endTimeList.add(bt.getEnd());
                        break;
                    }
                } else {
                    endTimeList.remove(cnt);
                    endTimeList.add(cnt, bt.getEnd());
                    break;
                }
                cnt++;
            }
        }

        return endTimeList.size();
    }
}