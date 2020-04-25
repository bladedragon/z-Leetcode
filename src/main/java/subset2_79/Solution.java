package subset2_79;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        getAns(nums,0,new ArrayList<Integer>(),ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for(int i =start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            getAns(nums,start,new ArrayList<>(path),ans);
        }
    }
}
