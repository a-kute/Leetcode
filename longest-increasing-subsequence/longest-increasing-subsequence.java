class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0]=1;
        for(int i = 1; i< nums.length; i++) {
            int curMax = 0;
            for(int j = 0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    curMax = Integer.max(curMax,dp[j]+1);
                }
            }
            dp[i] = Math.max(1,curMax);
            max = Integer.max(max,dp[i]);
        }
        return max;
        
    }
}