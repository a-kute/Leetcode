class Solution {
    public int maxProfit(int[] prices) {
        int[] arr = new int[prices.length];
        arr[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length-2; i>=0; i--) {
            arr[i] = Math.max(arr[i+1],prices[i]);
        }
        int max = 0;
        for(int i = 0; i< prices.length; i++) {
            max = Math.max(arr[i]-prices[i],max);
        }
        return max;
    }
}