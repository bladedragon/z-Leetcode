package backspaceCompare;

import java.util.Stack;

class Solution {
    /**
     * 传统方法比较退格字符串
     */
//    public boolean backspaceCompare(String S, String T) {
//        Stack<Character> s1 = new Stack<>();
//        Stack<Character> s2 = new Stack<>();
//        for(char c : S.toCharArray()){
//
//            if(c == '#'){
//                if(!s1.isEmpty()){
//                    s1.pop();
//                }
//            }else{
//                s1.push(c);
//            }
//        }
//        for(char c2: T.toCharArray()){
//            if(c2 == '#'){
//                if(s2.isEmpty()){
//                    s2.pop();
//                }
//            }else{
//                s2.push(c2);
//            }
//        }
//        while(s1.pop() != null && s2.pop() != null) {
//            if (!s1.pop().equals(s2.pop())) {
//                return false;
//            }
//        }
//            if(s1.pop() != null || s2.pop() != null){
//                return false;
//            }
//            return true;
//    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

}
