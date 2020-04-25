package longestCommonPrefix_14;

import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs){
        int minLen = Integer.MAX_VALUE;
        for(int i =0;i<strs.length;i++){
            minLen = Math.min(strs[i].length(),minLen);
        }

        char[][] chars = new char[strs.length][minLen];
        for(int i =0;i<strs.length;i++){
            char[] ss = strs[i].toCharArray();
            System.arraycopy(ss, 0, chars[i], 0, minLen);
        }

        char[] common = new char[minLen];
        for(int i =0;i<minLen;i++){
            common[i] = chars[0][i];

            for(int j = 1;j<strs.length;j++){
                if(chars[j][i] != common[i]){
                    break;
                }
            }
        }
        if(common.length == 0){
            return "";
        }
        return String.valueOf(common);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            System.out.println(strs[i].indexOf(prefix));
            //说明该前缀存在
            while (strs[i].indexOf(prefix) != 0) {
                //缩小前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix3(String[] strs){
        int minLen = Integer.MAX_VALUE;
        for(int i =0;i<strs.length;i++){
            minLen = Math.min(strs[i].length(),minLen);
        }
        int low = 0;
        int high = minLen;

        while(low < high){
            int mid = low+((high-low)>>1);
            if(isCommonPrefix(strs,mid)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return strs[0].substring(0,(low+high)/2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"flower","fl","flight"};
        System.out.println(s.longestCommonPrefix2(strs));
    }
}
