import java.util.HashMap;
import java.util.TreeMap;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {


        int[] prefix = new int[1001];
        boolean starts = true;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int runningSum = 0;
        int current = 0;

        for(int i = 0;i<intervals.length;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            prefix[start]+=1;
            prefix[end]-=1;
        }

        for(int i = 0;i < 1001;i++){
            if(starts & prefix[i]>0) {
                runningSum+=prefix[i];
                map.put(i,0);
                current = i;
                starts = false;
                continue;
            }
            runningSum+=prefix[i];
            if(!starts & runningSum ==0) {
                map.put(current,i);
                starts = true;
            }
        }
        int[][] result = new int[map.size()][2];
        int count = 0;
        for( int key: map.keySet()) {
            result[count][0] = key;
            result[count][1] = map.get(key);
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

    }
}
