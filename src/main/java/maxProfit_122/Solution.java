package maxProfit_122;

import static java.lang.Math.max;

public class Solution {

    public int  maxProfit(int[] prices){
        if(prices.length < 1){
            return 0;
        }
        int res = 0;
        for(int i =-0;i<prices.length;i++){
            int profit = prices[i] - prices[i-1];
            if(profit >0){
                res += profit;
            }
        }
        return res;
    }

    //每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
    //
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
    //解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
        int maxProfit_with_cool(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            // 代表 dp[i-2][0]
            int dp_pre_0 = 0;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = max(dp_i_1, dp_pre_0 - prices[i]);
                dp_pre_0 = temp;
            }
            return dp_i_0;
        }

        //每次交易要支付手续费，只要把手续费从利润中减去即可。改写方程：
        //
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
        //解释：相当于买入股票的价格升高了。
        //在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
        int maxProfit_wih_fee(int[] prices,int fee){
            if(prices.length < 1){
                return 0;
            }
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

            for(int i =-0;i<prices.length;i++){
                int temp = dp_i_0;
                dp_i_0 = max(dp_i_0,dp_i_1+prices[i]);
                dp_i_1 = max(dp_i_1,temp-prices[i]-fee);
            }
            return dp_i_0;

        }

        //k = 2 和前面题目的情况稍微不同，因为上面的情况都和 k 的关系不太大。要么 k 是正无穷，状态转移和 k 没关系了；
        // 要么 k = 1，跟 k = 0 这个 base case 挨得近，最后也没有存在感。
    //这道题 k = 2 和后面要讲的 k 是任意正整数的情况中，对 k 的处理就凸显出来了。我们直接写代码，边写边分析原因。
    //
    //原始的动态转移方程，没有可化简的地方
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    public int maxProfit_with_k2(int[] prices){
        if(prices.length <1){
            return 0;
        }
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }

    //2.
    // 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    //6.k = any integer

    int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;
        if (max_k > n / 2) {
            return maxProfit_k_inf(prices);
        }
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) { /* 处理 base case */}
                dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

}
