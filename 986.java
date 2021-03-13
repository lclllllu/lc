class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int m = firstList.length, n = secondList.length;
        
        if (firstList == null || m == 0 || secondList == null || n == 0) {
            return new int[][]{};
        }
        
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();
        
        while (i < m && j < n) {
            
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);
            
            if (endMin >= startMax) {
                result.add(new int[]{startMax, endMin});
            }
            
            if (firstList[i][1] == endMin) i++;
            else j++;
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}
