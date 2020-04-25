package isValid;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    private HashMap<Character,Character> mapping;

    public Solution(){
        this.mapping = new HashMap<Character, Character>();
        mapping.put(')','(');
        mapping.put(']','[');
        mapping.put('}','{');

    }

    /**
     * 判断括号是否有效
     * @param s
     * @return
     */
    public boolean isVaild(String s){

        Stack<Character> stack = new Stack<Character>();

        for(int i =0 ;i < s.length();i++){
            char c = s.charAt(i);
            if(this.mapping.containsKey(c)){
                char topElement = stack.empty() ? '#' :stack.pop();

                if(topElement != this.mapping.get(c)){
                    return false;
                }

            }else{
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[(())()]";
        Solution solution = new Solution();

        System.out.println(solution.isVaild(s));
    }

}
