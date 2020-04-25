package myAtoi_8;

import java.util.ArrayList;
import java.util.List;

public class Solutioin {
    /**
     * 无法完全通过，缺少正负号判断和空格判断
     * @param s
     * @return
     */
    public int myAtoi(String s){
        s.trim();
        int i =0;
        List<Integer> list = new ArrayList<Integer>();
        if(s.equals("")){
            return 0;
        }

        while(i <s.length() &&isdigit(s.charAt(i))){

            list.add(s.charAt(i) - '0');
            i++;
        }
        System.out.println(list);
        int res = 0;
        int ten = 1;
        for(int j =1;j<=list.size();j++){
            if (res > Integer.MAX_VALUE / 10 || (res > Integer.MAX_VALUE - 2000000000  &&  list.get(list.size()-i) ==2)){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res < Integer.MIN_VALUE + 2000000000 && list.get(list.size()-i) ==-2)){
                return Integer.MIN_VALUE;
            }
            res += list.get(list.size()-j)*ten;
            ten *=10;
        }
        return res;
    }

    private boolean isdigit(char c) {
        if(c <= '9' && c >='0'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Solutioin s = new Solutioin();
        System.out.println(s.myAtoi("42"));
    }
}
