package zigzagLevelOrder_103;

import java.util.*;

public class Solution {
    public  List<List<Integer>>  zigzagLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        boolean isOdd = true;
        int tempSize = 1;
        while(!queue.isEmpty()){
            List<Integer> templist = new ArrayList<>();
            while(tempSize != 0){
                TreeNode node = queue.poll();
                templist.add(node.val);
                if(node.left !=null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                tempSize--;
            }
            if(!isOdd){
                Collections.reverse(templist);
            }
            isOdd = !isOdd;
            res.add(templist);
            tempSize = queue.size();
        }
        return res;
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
