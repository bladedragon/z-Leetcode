package findCombinations_77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public void findCombinations(int n, int k,int begin, List<Integer> pre){
        if(pre.size() == k){
            res.add(new ArrayList<>(pre));
            return;
        }
        for(int i =begin;i<=n;i++){
//            pre.add(i);
            List<Integer> newlist = new ArrayList<>(pre);
            newlist.add(i);
            findCombinations(n,k,i+1,newlist);
//            pre.remove(pre.size()-1);
        }
    }
    public List<List<Integer>> combine(int n,int k){
        if( n <= 0 || k <=0 || n < k){
            return res;
        }
        findCombinations(n,k,1,new ArrayList<>());
        return  res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>>  res =s.combine(4,2);
        System.out.println(res);

    }
}
