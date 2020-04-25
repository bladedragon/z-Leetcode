package findMedianSortedArrays_4;

import java.util.Arrays;

public class Others {
    private  double findMedianSortedArrays(int[] nums1,int[] nums2){
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }
        double media = 0;
        int[] both = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,both,0,nums1.length);
        System.arraycopy(nums2,0,both,nums1.length,nums2.length);
        Arrays.sort(both);
        if(both.length%2 == 0){
            media = (both[both.length/2-1]+both[both.length/2])/2.0;
        }else{
            media = both[both.length/2];
        }
        return media;
    }

    public double finsMedianSortedArrays2(int[] A,int[] B){
        int m = A.length;
        int n = B.length;
        int len = n+m;
        int left = -1,right = -1;
        int aStart = 0,bStart = 0;
        for(int i =0;i<=len/2;i++){
            left = right;
            if(aStart < m && (bStart >=n || A[aStart] < B[bStart])){
                right = A[aStart++];
            }else{
                right = B[bStart++];
            }
        }
        if((len &1) == 0){
            return  (left +right)/2.0;
        }else{
            return right;
        }
    }
}
