import java.util.*;

class Solution {
	class Music implements Comparable<Music> {
		public String name;
		public int startTime;
		public int playTime;
		public String code;

		public Music(String name, int startTime, int playTime, String code) {
			this.name = name;
			this.startTime = startTime;
			this.playTime = playTime;
			this.code = code;
		}

		@Override
		public int compareTo(Music o1) {
			if (playTime == o1.playTime) return startTime - o1.startTime;
			return o1.playTime - playTime;
		}
	}
	
	public HashMap<String, String> map;

	public String solution(String m, String[] musicinfos) {
		map = new HashMap<>();
		for (int i = 0; i < ('H' - 'A'); i++) {
			if (i == 4) continue;	// 1 : B#, 4 : E#
			map.put(Character.toString('A' + i) + "#", String.valueOf(i));
		}
		
		m = parse(m);
		
		PriorityQueue<Music> pq = new PriorityQueue<>();
		for (String musicInfo : musicinfos) {
			String[] info = musicInfo.split(",");
			int playTime = getTime(info[0], info[1]);
			String code = getCode(parse(info[3]), playTime);
			
			if (code.contains(m)) {
				int startTime = getTime(info[0]);
				String name = info[2];
				pq.offer(new Music(name, startTime, playTime, code));				
			}
		}
		
		if (!pq.isEmpty()) return pq.poll().name;
		return "(None)";
	}
	
	public int getTime(String start, String end) {
		int startTime = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3));
		int endTime = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3));
		int playTime = endTime - startTime;
		return playTime;
	}
	
	public int getTime(String start) {
		return Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3));
	}
	
	public String getCode(String code, int playTime) {
		int len = code.length();
		if (len < playTime) {
			int quotient = playTime / len;
			int remainder = playTime % len;
			String tmp = "";
			for (int i = 1; i < quotient; i++) {
				tmp += code;
			}
			code +=  tmp + code.substring(0, remainder);
		} else if (len > playTime) {
			code = code.substring(0, playTime);
		}
		return code;
	}
	
	public String parse(String str) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			str = str.replaceAll(entry.getKey(), entry.getValue());
		}
		return str;
	}
}