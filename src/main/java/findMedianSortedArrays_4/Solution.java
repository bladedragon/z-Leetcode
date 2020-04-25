package findMedianSortedArrays_4;

import java.util.Arrays;

public class Solution {


    public double findMedianSortedArrays2(int[] nums1,int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        //如果是总长度偶数，则得到原来的中间数
        int left = (n+m+1)/2;
        //如果总长度是奇数，得到平均值+1
        int right = (n+m+2)/2;
        return (getKth(nums1,0,n-1,nums2,0,m-1,left) +getKth(nums1,0,n-1,nums2,0,m-1,right))/2.0;
    }

    private int getKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
    int len1 = end1-start1+1;
    int len2 = end2-start2+1;
    //使得最后取中位数一定在2的数组上
    if(len1 > len2){
        return getKth(nums2,start2,end2,nums1,start1,end1,k);
    }

    if(len1 == 0){
        return nums2[start2+k-1];
    }
    if(k ==1){
        return Math.min(nums1[start1],nums2[start2]);
    }
        //指的是长度
    int i = start1 + Math.min(len1,k/2) - 1;
    int j = start2 + Math.min(len2,k/2) - 1;

    if(nums1[i] > nums2[j]){
        return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
    }else{
        return getKth(nums1,i+1,end1,nums2,start2,end2,k - (i-start1+1));
    }
}


//类似于堆排序，同时二分地查找i

        public double findMedianSortedArrays3(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) {
                return findMedianSortedArrays3(B,A); // 保证 m <= n
        }
            int iMin = 0, iMax = m;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                //这样可以保证i后移地时候j前移
                int j = (m + n + 1) / 2 - i;
                if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                    iMin = i + 1;
                }
                else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                    iMax = i - 1;
                }
                else { // 达到要求，并且将边界条件列出来单独考虑
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }

                    if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
                }
            }
            return 0.0;
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays2(new int[]{1,2}, new int[]{3,4}));
    }
}
