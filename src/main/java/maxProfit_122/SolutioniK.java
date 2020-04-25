package maxProfit_122;

/**
 * 可以进行k次交易
 */
public class SolutioniK {
    public int maxProfit(int k,int[] prices){
        int len = prices.length;
        if(k == 0 || len  <2){
            return 0;
        }
        //特判：一次交易至少需要 2 天，一天买，一天卖。
        // 因此如果 k 很大，大到大于等于 len / 2，就相当于股票系列的第 2 题，使用贪心算法去做就可以了。这是一个特判。
        if(k >= len/2){
            return greedy(prices);
        }
        //到下标为 i 的天数为止（从 0 开始），到下标为 j 的交易次数（从 0 开始）
        // 状态为 K 的最大利润，K = 0 表示不持股，K = 1 表示持股
        int[][][] dp = new int[len][k][2];

        // 初始化：把持股的部分都设置为一个较大的负值
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j][1] = -9999;
            }
        }

        for(int i =0;i<len;i++){
            for(int j =0;j<k;j++){
                //第一天设置初始值
                if(i == 0){
                    dp[i][j][1] = -prices[0];
                    dp[i][j][0] = 0;
                }else{
                    if (j == 0) {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                    } else {
                        // 基本状态转移方程 1
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                    // 基本状态转移方程 2
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                }
            }
        }

        // 说明：i、j 状态都是前缀性质的，只需返回最后一个状态
        return dp[len - 1][k - 1][0];
    }

    private int greedy(int[] prices) {
        // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
        int res = 0;
        for (int i = 1; i < prices.length;i++) {
            if (prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
