package general;

public class LC42TrappingRainWater {

    /*
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
    In this case, 6 units of rain water (blue section) are being trapped.
    */
    public int trap(int[] height) {

        // create a variable to store the total amount of trapped rainwater
        int total = 0;

        // create an array to store the maximum value to the left of the current index
        // create an array to store the maximum value to the right of the current index
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];

        for (int i = 1; i < maxLeftHeight.length - 1; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i - 1]);
        }
        for (int i = maxLeftHeight.length - 2; i > 0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i + 1]);
        }

        // loop through all the values in heights
        for (int i = 1; i < height.length - 1; i++) {

            // retrieve the maximum values to the right and left of the current index
            int maxLeft = maxLeftHeight[i];
            int maxRight = maxRightHeight[i];

            // calculate the total amount of rainwater that could be trapped
            int currentRainWaterTrapped = Math.min(maxLeft, maxRight) - height[i];

            // check if any rainwater was able to be trapped
            if (currentRainWaterTrapped > 0)
                total += currentRainWaterTrapped;

        }
        return total;
    }

    public static void main(String[] args) {
        LC42TrappingRainWater obj = new LC42TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(obj.trap(height));
    }

}
