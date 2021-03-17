class Solution {
    public int findMinArrowShots(int[][] points) {
        
        if (points == null || points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return 0;
            if (a[1] < b[1]) return -1;
            return 1;
        });
                
        int min = points[0][1];
        int count = 1;
        
        for (int i = 1; i < points.length; i++) {
            if (min >= points[i][0]) {
                continue;
            }
            count++;
            min = points[i][1];
        }
        
        return count;
    }
}
