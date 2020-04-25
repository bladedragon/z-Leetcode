package reverse_7;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int reverse(int x) {

        List<Integer> list = new ArrayList<Integer>();

        while(x!=0){
            list.add(x%10);
            x /=10;
        }
        System.out.println(list);
        int res = 0;

        int ten = 1;

        for(int i =1;i<=list.size();i++){
            System.out.println(res);
            if (res > Integer.MAX_VALUE / 10 || (res > Integer.MAX_VALUE - 2000000000  &&  list.get(list.size()-i) ==2)){

                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res < Integer.MIN_VALUE + 2000000000 && list.get(list.size()-i) ==-2)){

                return 0;
            }
            System.out.println(list.get(list.size()-i));
            res+=list.get(list.size()-i)*ten;
            ten *=10;
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int x = s.reverse(-1563847412);
        System.out.println(x);
        System.out.println(Integer.MIN_VALUE);
    }
}