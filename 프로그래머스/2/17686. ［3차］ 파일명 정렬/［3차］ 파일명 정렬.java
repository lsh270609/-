import java.util.*;

class Solution {
    private class Record {
		private String file;
		private String head;
		private int number;

		public Record(String file, String head, int number) {
			this.file = file;
			this.head = head.toUpperCase();
			this.number = number;
		}

		public String getFile() {
			return file;
		}
		public String getHead() {
			return head;
		}
		public int getNumber() {
			return number;
		}		
	}

	public String[] solution(String[] files) {
		int len = files.length;
		Record[] recArr = new Record[len];
		for (int i = 0; i < len; i++) {
			recArr[i] = split(files[i]);
		}
        
		Arrays.sort(recArr, new Comparator<Record>() {
			@Override
			public int compare(Record o1, Record o2) {
				if(o1.getHead().equals(o2.getHead())) {
					return o1.getNumber() - o2.getNumber();
				} else return o1.getHead().compareTo(o2.getHead());
			}
		});
        
		String[] answer = new String[len];
		for (int i = 0; i < len; i++) {
			answer[i] = recArr[i].getFile();
		}
        
		return answer;
	}

	public Record split(String file) {
		int headIdx = 0, numberIdx = 0;
		boolean flag1 = true;
		for (char c : file.toCharArray()) {
			if (flag1 && (c < '0' || c > '9')) headIdx++;
			else if (c >= '0' && c <= '9') {
				if (flag1) flag1 = false;
				if (numberIdx == 5) break;
				numberIdx++;
			} else break;
		}
		return new Record(file, file.substring(0, headIdx), Integer.parseInt(file.substring(headIdx, headIdx + numberIdx)));
	}
}