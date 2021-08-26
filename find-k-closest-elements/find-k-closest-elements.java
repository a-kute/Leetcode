class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr,x);
        boolean exist;
        if(index < 0){
            exist = false;
            index = (index*-1)-1;
            if(index!=0 && index!=arr.length) {
                if(Math.abs(arr[index-1]-x)<=Math.abs(arr[index]-x)) {
                    index--;
                }
            }
            if(index==arr.length) index--;
        } else {
            exist = true;
            index = index;
        }
        List<Integer> result = new ArrayList<Integer>();
        int leftPointer = index;
        int rightPointer = index;
        int count = 0;
        result.add(arr[index]);
        count++;
         
       while (true) {
           if(count==k) {
               Collections.sort(result);
               return result;
           }
           if(leftPointer-1>=0 && rightPointer+1<arr.length) {
               if(x-arr[leftPointer-1] <= arr[rightPointer+1]-x){
                   result.add(arr[leftPointer-1]);
                   leftPointer--;
                   count++;
                   continue;
               } else {
                   result.add(arr[rightPointer+1]);
                   rightPointer++;                   
                   count++;
                   continue;
               }
           }
           else if(leftPointer-1>=0) {
                result.add(arr[leftPointer-1]);
                   leftPointer--;
                   
                   count++;
                   continue;
           } else  {
              result.add(arr[rightPointer+1]);
                   rightPointer++;
                   
                   count++;
                   continue;
           }
           
       }
        
    }
}