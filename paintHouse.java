class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int length = costs.length;
        int[][] dp = new int[length][3];
 
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[i][j] = costs[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3]
                                    , dp[i - 1][(j + 2) % 3] ) + costs[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            result = Math.min(dp[length - 1][i], result);
        }
        return result;
    }
}
