class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int min = intervals[0][0];
        int max = intervals[0][1];
        for(int i = 1 ; i< intervals.length; i++) {
            int[] current = intervals[i];
            if(current[0]<=max){
                max = Math.max(max, current[1]);
            } else {
                int[] add = new int[]{min,max};
                answer.add(add);
                min = current[0];
                max = current[1];
            }
        }
        int[] add = new int[]{min,max};
        answer.add(add);
               
        
        int[][] ans = new int[answer.size()][2];
        for(int i = 0; i< answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
        
    }
}