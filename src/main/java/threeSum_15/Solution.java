package threeSum_15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        int sum = 0;
        if(nums[0]>0){
            return new ArrayList<>(res);
        }
        for(int i =0;i<nums.length ;i++){
            int first = nums[i];
            int j = i+1;
            int k = nums.length - 1;
            while(j<k){
                int temp = nums[j] + nums[k] + first;
                if(temp == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(first);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                }else if(temp >0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1,0,0, 2, -1,-1, -4};
        List<List<Integer>> res = solution.threeSum(nums);
        for(List<Integer> list : res){
            System.out.println(list);
        }
    }

}
