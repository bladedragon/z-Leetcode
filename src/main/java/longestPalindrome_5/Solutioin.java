package longestPalindrome_5;

public class Solutioin {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        //回文可以从它的中心展开，并且只有 2n−1 个这样的中心。（中心是奇一个字符时有n个中心，中心是2个字符时有n-1个）
        for (int i = 0; i < s.length(); i++) {
            //每次去判断两种情况
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public static String longestPalindrometest(String s){
        int start = 0;
        int edn = 0;
        for(int i =0;i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > edn -start){
                start = i = (len-1) /2;
                edn = i+len /2;
            }
        }
        return s.substring(start,edn+1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }



    public static String M_init(String s){
        StringBuilder builder = new StringBuilder();
        builder.append("$#");
        for(int i =0;i<s.length();i++){
            builder.append(s.charAt(i));
            builder.append("#");
        }
        return builder.toString();
    }
    public static int Manacher(String s){
        String  str = M_init(s);
        int max_len = -1;
        int len = str.length();
        int[] p = new int[len];
        //mx 代表以 id 为中心的最长回文的右边界，也就是mx = id + p[id]
        int mx = 0;
        int id = 0;
        for(int i=1;i<len;i++){
            if(i< mx){
                p[i] = Math.min(p[2*id -i],mx-i);
            }else{
                p[i] = 1;
            }
            while(str.charAt(i-p[i]) == str.charAt(i+p[i])){
                p[i] ++;
            }
            if (i + str.charAt(i)> mx) {
                id = i;
                mx = i + str.charAt(i);
            }
            max_len = Math.max(max_len,p[i]-1);
        }
        return max_len;
    }

    public static void main(String[] args) {
        System.out.println(Manacher("ababa"));
    }

}
