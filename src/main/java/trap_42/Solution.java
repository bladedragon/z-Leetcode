package trap_42;

public class Solution {
    public int trap(int[] height){
        if(height.length <=2){
            return 0;
        }

        int max = 0;
        int maxIndex = 0;
        for(int i =0;i<height.length;i++){
            if(max < height[i]){
                max = height[i];
                maxIndex = i;
            }
        }

        int total =0;
        int topIndex = 0;
        for(int i =0;i<maxIndex;i++){
            if(height[i] > height[topIndex]){
                topIndex = i;
            }else{
                total += height[topIndex] - height[i];
            }
        }

        topIndex = height.length-1;
        for(int i = height.length-1;i>maxIndex;i--){
            if(height[i] > height[topIndex]){
                topIndex = i;
            }else{
                total += height[topIndex]-height[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(solution.trap(nums));
    }
}
