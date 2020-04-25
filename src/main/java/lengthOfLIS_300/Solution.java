package lengthOfLIS_300;

import java.util.Arrays;

public class Solution {
    public static int lengthOfLIS(int[] a){
        if(a.length <= 0){
            return 0;
        }
        int[] state = new int[a.length];
        Arrays.fill(state,1);
        int res = 0;
        for(int i = 0; i < a.length;i++){
            for(int j =0; j < i;j++){
                if(a[j] < a[i]){
                    //state[i]是可能变化的
                    state[i] = Math.max(state[i],state[j]+1);
                }
            }
            res = Math.max(res,state[i]);
        }

        return res;
    }

    public static int lengthOfLIS2(int[] a){
     if(a.length <= 0){
         return 0;
     }
     int[] tails = new int[a.length];
     int res =0;
     for(int num : a){
         int i =0;
         int j =res;
         while(i <j){
             int mid = (i+j)/2;
             if(tails[mid] < num){
                 i = mid+1;
             }else{
                 j = mid;
             }
         }
         tails[i] = num;
         if(res == j){
             res++;
         }
     }
     return res;
    }


    public static void main(String[] args) {
        int[] a= {2, 9, 3, 6, 5, 1, 7,1,2};
        System.out.println(Solution.lengthOfLIS2(a));
    }
}
