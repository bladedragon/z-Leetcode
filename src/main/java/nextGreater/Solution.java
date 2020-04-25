package nextGreater;


import java.util.HashMap;
import java.util.Stack;

class Solution {

    /**
     * 单调栈用法
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack < Integer > stack = new Stack < > ();
        //首先制作临时存储答案HashMap
        HashMap < Integer, Integer > map = new HashMap< >();
        int[] res = new int[findNums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        //数组照着答案去遍历匹配
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;


    }
//
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] result = new int[nums1.length];
//        for(int i = 0;i< nums1.length;i++){
//                result[i] = -1;
//            int flag = 0;
//            for(int j = 0;j<nums2.length;j++){
//
//                if(nums1[i] == nums2[j]){
//
//                    flag =1 ;
//                }
//
//                if(nums2[j] > nums1[i] && flag == 1){
//                    System.out.println("true");
//                     result[i] = nums2[j];
//                     break;
//                }
//
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        int[] res = solution.nextGreaterElement(num1,num2);
        System.out.println(res[1]);
    }
}