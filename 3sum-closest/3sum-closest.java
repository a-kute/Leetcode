class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int cabs=10000;
        for(int i = 0; i<nums.length-2;i++) {
            //int newTarget = target-nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                int abs =  Math.abs(sum-target);
                if(abs==0) return target;
                if(abs<cabs){
                    closest = sum;
                    cabs = abs;
                }
                
                if(sum>target){
                    end--;
                }else if(sum<target){
                    start++;
                } else{
                    break;
                }
            }
        }
        return closest;
        
    }
}