package checkInclusion_567;

import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1,String s2){
        char[] cs1 = s1.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        char[] map = new char[26];
        char[] map2 = new char[26];

        for(int i =0;i<len1;i++){
            map[cs1[i]-'a']++;
        }

        for(int i=0;i<len2;i++){
            if (i >= len1) {
                //先把坐标查过的减掉
                --map2[s2.charAt(i - len1) - 'a'];
            }
            map2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(map,map2)){
                return true;
            }
        }
        return false;
    }
}
