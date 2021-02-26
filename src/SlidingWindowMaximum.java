import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer>  q =
                new PriorityQueue<Integer>(k,
                        Collections.reverseOrder());
        int[] result = new int[nums.length-k+1];
        int counter = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < k-1; i++) {
            q.add(nums[end]);

            end++;
        }
        q.add(nums[end]);
        result[counter] = q.peek();
        counter++;

        for(int i = 0; i < nums.length-k;i++){
            q.remove((Integer)nums[start]);
            start++;
            end++;
            q.add(nums[end]);

            result[counter] = q.peek();
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
