package maxProfit_122;

/**
 * 自己尝试的动态规划解法
 */
public class Solution2 {

    /**
     * 允许交易两笔
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        // dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //3状态无效，其实4状态也可以写作无效
        for(int i =0;i<len;i++){
            dp[i][3] = Integer.MIN_VALUE;
        }

        for(int i =0;i<len;i++){

            dp[i][0] = 0;
            //要么保持，要么从状态0转移过来
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] -prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }
        return Math.max(0, Math.max(dp[len - 1][2], dp[len - 1][4]));
    }

    /**
     * 允许交易两笔的其他解法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // 特判
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // [0, left] 包括 left 这个区间完成一次交易能够获得的最大利润
        int[] left = new int[len];
        int minVal = prices[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }

        // [right, len - 1] 包括 left 这个区间完成一次交易能够获得的最大利润
        int[] right = new int[len];
        int maxVal = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxVal - prices[i]);
            maxVal = Math.max(maxVal, prices[i]);
        }

        // 枚举间隙
        // [0, 1[, 2, 3,] 4, 5]
        // 这里有一个坑，有可能是只交易一次的场景
        int res = Math.max(left[len - 1], right[0]);
        for (int i = 1; i < len - 2; i++) {
            res = Math.max(res, left[i] + right[i + 1]);
        }
        return res;
    }

}
