public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int start1 = 0;
        int start2 = 0;
        int end1 = nums1.length-1;
        int end2 = nums2.length-1;
        int uno = 0;
        int dos = 0;
        if(start1<=end1) {
            uno = end1-start1+1;
        }
        if(start2<=end2) {
            dos = end2-start2+1;
        }
        int totalCount = uno+dos;
        if(nums1.length ==0) {
            int c = nums2.length;
            if(c%2==1) return nums2[c/2];
            return (nums2[c/2]+nums2[c/2 -1] )/(double)2;

        } else if(nums2.length ==0) {
            int c = nums1.length;
            if(c%2==1) return nums1[c/2];
            return (nums1[c/2]+nums1[c/2 -1]) /(double)2;
        }
        double lower1=0;
        double lower2=0;
        double higher1=0;
        double higher2=0;
        while(totalCount!=2 && totalCount!=1) {
            if(start1<nums1.length)lower1 = nums1[start1];
            if(start2<nums2.length)lower2 = nums2[start2];
            if(end1>=0) {
                higher1 = nums1[end1];
            }
            if(end2>=0){
                higher2 = nums2[end2];
            }
            //removeLeast
            if(start1>end1) {
                start2++;
            } else if(start2>end2) {
                start1++;
            } else {
                if(lower1>lower2){
                    start2++;
                }else {
                    start1++;
                }
            }

            //removeLargest
            if(start1>end1) {
                end2--;
            } else if(start2>end2) {
                end1--;
            } else {
                if(higher1>higher2){
                    end1--;
                }else {
                    end2--;
                }
            }
            uno = 0;
            dos = 0;
            if(start1<=end1) {
                uno = end1-start1+1;
            }
            if(start2<=end2) {
                dos = end2-start2+1;
            }
            totalCount = uno+dos;
        }
        if(totalCount==1){
           if(start1==end1) return nums1[end1];
           if(start2==end2) return nums2[end2];
        }
        if(totalCount==2) {
            if(start1<end1 && start2>end2){
                double a = nums1[start1]+nums1[end1];
                return a/2;
            }
            if(start1>end1 && start2<end2){
                double a = nums2[start2]+nums2[end2];
                return a/2;
            }
            if(start1==end1&&start2==end2){
                double a = nums1[start1]+nums2[start2];
                return a/2;
            }
            if(start1==end1)return nums1[start1];
            if(start2==end2)return nums2[start2];
        }
       return 100;

    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] a = {1,2,3,5,7};
        int[] b = {2,3,4};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(a,b));
    }


}
