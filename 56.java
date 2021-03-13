class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        
        int[] lastInterval = intervals[0];
		result.add(lastInterval);
        
		for (int[] interval : intervals) {
            if (interval[0] <= lastInterval[1]) {
				lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
				lastInterval = interval;
				result.add(lastInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
    }
}
