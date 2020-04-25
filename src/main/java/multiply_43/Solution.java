package multiply_43;

import java.util.Arrays;

public class Solution {
    public String multiply(String num1,String num2){

        if(num1 == null || num2 == null){
            return null;
        }
        int[] res = new int[num1.length()+num2.length()-1];

        Arrays.fill(res,0);
        for(int i =0;i<num1.length();i++){
            for(int j =0;j<num2.length();j++){
                res[i+j] += (num1.charAt(i)-'0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder resStr = new StringBuilder();
        int addIn = 0;
        for(int i = res.length-1;i>= 0;i--){
            int t = res[i]+addIn;
            addIn = t/10;
            //这里是从个位开始添加到字符串的
            resStr.append(t%10);
        }

        if (addIn > 0) {
            resStr.append(addIn);
        }
        System.out.println(resStr);
        return resStr.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.multiply("12" ,"1");
        System.out.println(res);
    }
}
