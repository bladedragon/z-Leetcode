package isPalindrome_9;

public class Solution {
    public boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        int div = 1;
        while( x/ div >= 10){
            div *= 10;
        }
        while(x >0){
            int left = x /div;
            int right = x %10;
            if(left != right){
                return false;
            }

            x = (x %div)/10;
            div /=100;
        }
        return true;
    }
    public boolean isPalindrome2(int x) {
        //末尾为0直接返回false
         if (x < 0 || (x % 10 == 0 && x!= 0)){
            return false;
        }
        int revertedNumber = 0;
         //两种情况：位数为奇数和位数为偶数
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome2(10001));
    }
}
