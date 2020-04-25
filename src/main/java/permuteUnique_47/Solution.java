package permuteUnique_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();

        boolean[] used=  new boolean[nums.length];
        Arrays.fill(used,false);
        if(nums.length == 0){
            return res;
        }

        dfs(res,path,used,nums,0,nums.length);

        return res;
    }

    public void dfs(List<List<Integer>> res,List<Integer> path,boolean[] used,int[] nums,int depth,int len){
        if(depth == len){
            // List<Integer> newPath = new ArrayList<Integer>(path);
            res.add(path);
            return;
        }

        for(int i =0;i<len;i++){
            if(!used[i]){
                //添加新的列表，每一层遍历都是新的列表，就不需要回溯
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;

                //关键在这里，剪除相同的重复的数字
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                dfs(res,newPath,newUsed,nums,depth+1,len);
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res  = s.permuteUnique(new int[]{1,2,3,4,5,6,6});
        System.out.println(res.size()   );
    }
}
