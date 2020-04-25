package calPoints;

import java.util.Stack;

public class Solution {

    public int calPoint(String[] ops){
        Stack<Integer> stack  = new Stack<>();
        int sum = 0;
        for (String s: ops) {
            if(s.equals("+")){
                int pop1 = stack.pop();
                int pop2 = stack.peek();
                int res = pop1+ pop2;
                sum += res;
                stack.push(pop1);
                stack.push(res);

                System.out.println(stack.peek());
            }else if(s.equals("D")){

                int pop1 =stack.peek()*2;
                stack.push(pop1);
                sum += pop1;
                System.out.println(stack.peek());
            }else if(s.equals("C")){
                stack.pop();
                System.out.println(stack.peek());
            }else{
                stack.push(Integer.valueOf(s));
                sum += Integer.valueOf(s);
                System.out.println(stack.peek());
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"5","2","C","D","+"};
        System.out.println(solution.calPoint(strs));
    }
}
