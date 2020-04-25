package romanToInt_13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int romanToInt(String s){
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Character,Integer> map  = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for(int i =0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                return 0;
            }

            if(i+1 <s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res-=map.get(s.charAt(i));
            }else{
                res+=map.get(s.charAt(i));
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "IV";
        int res = romanToInt(s);
        System.out.println(res);
    }
}
