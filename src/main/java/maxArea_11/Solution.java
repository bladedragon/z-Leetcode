package maxArea_11;

public class Solution {
    public int maxArea(int[] height){
        int maxArea =0;
        int i =0;
        int j = height.length-1;
         while(j> i){
             maxArea = height[i] < height[j] ?
                     Math.max(maxArea, (j - i) * height[i++]):
                     Math.max(maxArea, (j - i) * height[j--]);
         }
         return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(res);
    }
}
