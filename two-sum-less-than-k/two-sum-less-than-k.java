class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
       Arrays.sort(nums);
       int left = 0;
       int right = nums.length-1;
        int max = -1;
        
        while(left<right){
            int current = nums[left]+nums[right];
            if(current<k){
                max = Integer.max(max, current);
                left++;
            } else{
                right--;
            }
            
        }
        
        return max;
        
        
    }
}