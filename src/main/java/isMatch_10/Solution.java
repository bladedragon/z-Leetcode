package isMatch_10;

public class Solution {


    public boolean isMatch(String s,String p){
        if((p == "" && s != "" )||(p != "" && s == "")){
            return false;
        }

        if(p.equals(".") && s.length() == 1){
            return true;
        }

        boolean flag = match(s,0,p,0);
        return flag;
    }

    private boolean match(String s, int i, String p, int y) {
            if(i == s.length() && y == p.length()){
                return true;
            }
            if(y +1 >    p.length()){
                return false;
            }
        if(y+1 < p.length() && p.charAt(y+1) == '*'){
            if(i < s.length() && (p.charAt(y) == '.' || p.charAt(y) == s.charAt(i))) {
                    return match(s,i+1,p,y) || match(s,i,p,y+2);
            }else{
                    return match(s,i,p,y+2);
            }
        }else{
            if(i<s.length() && (p.charAt(y) == '.' || s.charAt(i) == p.charAt(y))){
                return match(s,i+1,p,y+1);
            }
        }
            return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aa","aa"));
    }
}
