public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int runningSum = 0;
        int laggingPointer = 0;
        int min = Integer.MAX_VALUE;


        for(int i = 0; i< nums.length;i++) {
            runningSum+=nums[i];
            while(runningSum>=target && laggingPointer<=i) {
                if(i-laggingPointer+1 < min) {
                    min = i-laggingPointer+1;
                }
                runningSum-=nums[laggingPointer++];
            }
        }
        return min==Integer.MAX_VALUE? 0: min;

    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] a = {2,3,1,2,4,3};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7,a));
    }
}
