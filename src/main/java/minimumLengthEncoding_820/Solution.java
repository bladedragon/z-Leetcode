package minimumLengthEncoding_820;

import java.util.*;

/**
 * 关机点在于如何存储后最
 */
public class Solution {
    private TrieNode root = new TrieNode('/');
    /**
     * 几个字符串就要建几棵树
     */
    Map<TrieNode,Integer> nodes = new HashMap();

    public void insert(String data,int j,TrieNode p){

        for(int i =data.length()-1; i >= 0;i--){
            int index = data.charAt(i) - 'a';
            if(p.children[index] == null){
                TrieNode newNode = new TrieNode(data.charAt(i));
                p.children[index] = newNode;
                p.count++;
            }
            p = p.children[index];
        }
            p.isEndingChar = true;
            nodes.put(p,j);

    }


        public int minimumLengthEncoding(String[] words) {
//        /*枚举所有字符串，删掉后缀，留下的就是最长的单词串*/
//            Set<String> good = new HashSet<>(Arrays.asList(words));
//            for(String word : words){
//                //i=1 确保不会吧最长的删掉
//                for(int i = 1;i<word.length();++i){
//                    good.remove(word.substring(i));
//                }
//            }
//
//            int ans = 0;
//            for(String word:good){
//                ans += word.length()+1;
//            }
//            return ans;

            TrieNode p = root;
            for(int i = 0;i<words.length;i++){
             insert(words[i],i,p);
            }
            int ans = 0;
                for (TrieNode node : nodes.keySet()) {
                    if (node.count == 0) {
                        ans += words[nodes.get(node)].length() + 1;
                    }
                }
            return ans;
        }

    public static void main(String[] args) {

        String[] ss = {"time","me","bell"};
        Solution solution = new Solution();
        System.out.println(solution.minimumLengthEncoding(ss));
    }
}
