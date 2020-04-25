package threeSumClosest_16;

import java.util.Arrays;

public class Solution {
    public static int threeSumClosest(int[] nums,int target){


        int res = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(Math.abs(nums[right] + nums[left]+nums[i] -target) < Math.abs(target-res)) {
                    res = nums[right] + nums[left] + nums[i];
                }if(nums[right] + nums[left] + nums[i] > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int res = threeSumClosest(nums,1);
        System.out.println(res);

    }
}
