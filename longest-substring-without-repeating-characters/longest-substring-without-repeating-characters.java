class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        char[] string = s.toCharArray();
        int lag = 0;
        int max = 0;
        for(int i = 0; i<string.length; i++) {
            count[string[i]] += 1;
            while(count[string[i]]>1) {
                count[string[lag++]]-=1;
            }
            max = Math.max(max, i-lag+1);
        }
        return max;
        
    }
}