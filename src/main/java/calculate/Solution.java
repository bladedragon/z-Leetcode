package calculate;

import java.util.Stack;

public class Solution {

    public int caculate(String s){
        Stack<Boolean> stack = new Stack<>();
        int result = 0,opr = 0;
        Character op = null;
        for(char c: s.toCharArray()){
            if(c == '+' || c == '-'){
                if(op == null){
                    result = opr;
                }else{
                    result = cal(op,result,opr);
                }
                op = swap(stack.isEmpty() ? false : stack.peek(), c);
                opr = 0;

            }else if(c == '('){
                //防止空指针报错
                stack.push(op != null &&op =='-');

            }else if(c == ')'){
                stack.pop();

            }else if(c != ' '){
                //将字符转换成数字
                opr = opr*10+c-'0';
            }
        }
        if(op ==null){
            return opr;
        }else{
            return cal(op,result,opr);
        }

    }

    public int cal(Character op,int result,int opr){
        switch(op){
            case '+' :
                return result + opr;

            case '-':
                return result -opr;
            default:
                return 0;
        }
    }

    public  char swap(boolean swap, char c){
        if(swap){
            return c =='+' ? '-': '+';
        }else{
            return c;
        }

    }


    public static void main(String[] args) {
        String s = "1+2";
        Solution solution = new Solution();
        solution.caculate(s);
    }
}
