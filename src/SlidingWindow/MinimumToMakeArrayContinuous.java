package SlidingWindow;

import java.util.Arrays;

public class MinimumToMakeArrayContinuous {

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int uniqueLen = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueLen++] = nums[i];
            }
        }

        int ans = nums.length;
        for (int i = 0, j = 0; i < uniqueLen; ++i) {
            while (j < uniqueLen && nums[j] - nums[i] <= nums.length - 1) {
                ++j;
            }
            ans = Math.min(ans, nums.length - (j - i));
        }

        return ans;

    }
    public static void main(String[] args){
        int[] arr={1,10,100,1000};
        MinimumToMakeArrayContinuous min=new MinimumToMakeArrayContinuous();
        System.out.println(min.minOperations(arr));
    }
}
