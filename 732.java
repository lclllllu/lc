class MyCalendarThree {

    private TreeMap<Integer, Integer> calendar = new TreeMap<>();
    
    public MyCalendarThree() {
        
    }
    
    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        
        int active = 0, result = 0;
        
        for(int c : calendar.values()) {
            active += c;
            result = Math.max(active, result);
        }
        
        return result;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
