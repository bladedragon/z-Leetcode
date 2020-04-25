package widthOfBinaryTree_662;

import java.util.*;

/**
 * Definition for a binary tree node.
 *
 */
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer,Integer> leftMap  = new TreeMap<>();
        Map<Integer,Integer> rightMap = new TreeMap<>();
        dfs(root,1,1,leftMap,rightMap);
        int max = 0;
        for(int i : rightMap.keySet()){
            //最右边节点值-最左边节点值+1得到树的宽度
            max = Math.max(max,rightMap.get(i) - leftMap.get(i)+1);
        }
        return max;
    }

    public void dfs(TreeNode node,int num,int level,Map<Integer,Integer> leftMap,Map<Integer,Integer> rightMap){

        //遍历到叶子节点
        if(node == null){
            return;
        }
        //每层第一次到达的就是最左边的节点，所以到达直接记录就行了
        if(!leftMap.containsKey(level)){
            leftMap.put(level,num);
        }
        //对于右边的节点不一定就是最右边的节点，因此要对节点的值进行判断
        if(!rightMap.containsKey(level) || rightMap.get(level) < num){
            rightMap.put(level,num);
        }

        dfs(node.left,2* num,level+1, leftMap,rightMap);
        dfs(node.right,2*num+1,level+1,leftMap,rightMap);



    }


    /**
     * 广度遍历算法
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root){
        Queue<AnnotateNode> queue = new LinkedList<>();
        queue.add(new AnnotateNode(root,0,0));
        int curDepth = 0,left =0, ans =0;
        while(!queue.isEmpty()){
            AnnotateNode a = queue.poll();
            if(a.node != null) {
                //添加左右节点，此时同一层的节点未必使用完
                queue.add(new AnnotateNode(a.node.left, a.depth + 1, 2 * a.pos));
                queue.add(new AnnotateNode(a.node.right, a.depth + 1, 2 * a.pos + 1));

                //切换到下一层的第一个节点时触发，此时一定时最左节点
                if(curDepth != a.depth){
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans,a.pos-left +1);
            }
        }
        return ans;
    }

    /**
     * 树的节点
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 通过包装TreeNode节点防止出现节点是null而报错
     */
  public class AnnotateNode{
        TreeNode node;
        //depth是节点所在深度
        //pos是节点的值
        int depth,pos;
        AnnotateNode(TreeNode n,int depth,int pos){
            this.node = n;
            this.depth = depth;
            this.pos = pos;
        }
  }
}
