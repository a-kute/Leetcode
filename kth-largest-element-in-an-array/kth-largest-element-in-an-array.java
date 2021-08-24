class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> a = new PriorityQueue<Integer>();
        //int size = nums.length-k+1;
        for(int num:nums) {
           a.add(num);
            if(a.size()>k) a.poll();
        }
        return a.peek();
        
    }
}