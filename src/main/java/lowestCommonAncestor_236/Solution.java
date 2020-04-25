package lowestCommonAncestor_236;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q ==  null){
            return null;
        }
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        dfs(root,p,list1);
        dfs(root,q,list2);

        TreeNode last = null;
        while(!list1.isEmpty() && !list2.isEmpty()){
            TreeNode pi = list1.pollFirst();
            TreeNode qi = list2.pollFirst();
            if(pi == qi){
                last = pi;
            }else{
                break;
            }
        }
        return last;
    }

    private void dfs(TreeNode root, TreeNode p,LinkedList<TreeNode> list) {
        if(root == null){
            return;
        }

        if (!list.isEmpty() && list.getLast().val == p.val) {
            return;
        }

        list.add(root);

        LinkedList<TreeNode> newList = new LinkedList<TreeNode>(list);

        dfs(root.left,p,newList);
//        if (!list.isEmpty() && list.getLast().val == p.val) {
//            return;
//        }

        dfs(root.right,p,newList);
//        if(!list.isEmpty() && list.getLast().val != p.val){
//            list.removeLast();
//        }
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3,new TreeNode(5,null,null),new TreeNode(1,null,null));
        TreeNode leftHead  = head.left;
        leftHead.left = new TreeNode(6,null,null);
        leftHead.right = new TreeNode(2,new TreeNode(7,null,null),new TreeNode(4,null,null));
        TreeNode rightHead = head.right;
        Solution s = new Solution();
        TreeNode res = s.lowestCommonAncestor(head,leftHead.left,leftHead.right);
        System.out.println(res.val);
    }
}