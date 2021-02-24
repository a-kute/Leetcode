import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer,Integer> set = new TreeMap<>();
        int[] result = new int[nums.length-k+1];
        int counter = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < k-1; i++) {
            if(set.containsKey(nums[end])) {
                set.put(nums[end],set.get(nums[end])+1);
            } else {
                set.put(nums[end],1);
            }
            end++;
        }
        if(set.containsKey(nums[end])) {
            set.put(nums[end],set.get(nums[end])+1);
        } else {
            set.put(nums[end],1);
        }
        result[counter] = set.lastKey();
        counter++;

        for(int i = 0; i < nums.length-k;i++){
            if(set.get(nums[start])==1) set.remove(nums[start]);
            else{
                set.put(nums[start],set.get(nums[start])-1);
            }
            start++;
            end++;
            if(set.containsKey(nums[end])) {
                set.put(nums[end],set.get(nums[end])+1);
            } else {
                set.put(nums[end],1);
            }

            result[counter] = set.lastKey();
            counter++;
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] a = {9,10,9,-7,-4,-8,2,-6,5};
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(a,5)));
    }
}
