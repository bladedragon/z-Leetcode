package candy_135;

import java.util.Arrays;

public class Solution {

        public int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);
            boolean flag = true;
            int sum = 0;
            while (flag) {
                flag = false;
                for (int i = 0; i < ratings.length; i++) {
                    if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                        candies[i] = candies[i + 1] + 1;
                        flag = true;
                    }
                    if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                        candies[i] = candies[i - 1] + 1;
                        flag = true;
                    }
                }
            }
            for (int candy : candies) {
                sum += candy;
            }
            return sum;
        }

        public int candy2(int[] rating){
            int right[] = new int[rating.length];
            int left[] = new int[rating.length];
            Arrays.fill(left,
                    1);
            Arrays.fill(right, 1);
            for(int i =1;i<rating.length;i++){
                if(rating[i] > rating[i-1]){
                    right[i] = right[i]+1;
                }
            }
            for(int i = rating.length-2;i >=0;i--){
                if(rating[i] > rating[i+1]){
                    left[i] = left[i+1]+1;
                }
            }
            int sum = 0;
            for(int i =0;i<rating.length;i++){
                sum+= Math.max(right[i],left[i]);
            }
            return sum;
        }

    /**
     * 空间复杂度减低，使用一个数组，特点是使用贪心算法
     * @param ratings
     * @return
     */

    public int candy3(int[] ratings) {
            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }
            int sum = candies[ratings.length - 1];
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
                sum += candies[i];
            }
            return sum;
        }

    /**
     *
     * @param n
     * @return
     */
    public int count(int n) {
            return (n * (n + 1)) / 2;
        }

    public int candy4(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            //维护两个变量old_slope 和new_slope 来决定现在是在峰还是在谷，同时我们用 up 和 down 两个变量分别记录上升或者下降坡中的学生个数（不包括峰点）
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0)
            {
                up++;
            }
            if (new_slope < 0)
            {
                down++;
            }
            if (new_slope == 0)
            {
                candies++;
            }

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }

    public static void main(String[] args) {
        Solution s=  new Solution();
        System.out.println(s.candy2(new int[]{1,2,2}));
    }
}
