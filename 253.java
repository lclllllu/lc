class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        int rooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (heap.isEmpty()) {
                rooms++;
                heap.offer(intervals[i][1]);
                continue;
            }
            int end = heap.peek();
            
            if (end <= intervals[i][0]) {
                heap.poll();
            } else if (heap.size() == rooms) {
                rooms++; 
            }
            
            heap.offer(intervals[i][1]);
        }
        
        return rooms;  
    }
}
