package simplifyPath_71;

import java.util.Stack;

public class Solution {
        public static String simplifyPath(String path){
            Stack<String> stack = new Stack<>();
            String[] spilt = path.split("/");
            for(String s : spilt){
                if(s.isEmpty()){
                    continue;
                }
                switch (s){
                    case ".." :
                        stack.pop();
                        break;
                    case ".":
                        break;
                    default:
                        stack.add(s);
                }
            }
            StringBuilder builder = new StringBuilder("/");
            for(String s:stack){
                builder.append(s);
                builder.append("/");
            }
            if(builder.length() > 1){
                builder.deleteCharAt(builder.length()-1);
            }
            return builder.reverse().toString();
        }
}
