package search_33;

import javax.xml.soap.SAAJMetaFactory;

public class Solution {
    public int search(int[] nums,int target){
        int left = 0;
        int right =nums.length-1;

        while(left <= right){
            int mid = left +((right-left)>>1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[left]){
                if(target < nums[mid] && target >= nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid] <= nums[right]){
                    if(target > nums[mid] && target <= nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid]==target) return mid;

            if (nums[mid] >= nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,4,5,1,2};
        int i = solution.search(nums,3);
        System.out.println(i);
    }
}
