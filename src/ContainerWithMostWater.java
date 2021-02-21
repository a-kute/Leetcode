public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = 0;
        while (start<end) {
            int smallest = height[start] > height[end] ?  height[end] : height[start];
            int difference = end-start;
            int area = smallest*difference;
            if (area>max) max = area;
            if(height[start] > height[end]) {
                end--; continue;
            } else {
                start++;continue;
            }

        }
        return max;


    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater.maxArea(array));
    }
}
