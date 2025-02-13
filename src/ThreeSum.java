import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int m, n, o;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            m = i;
            n = i + 1;
            o = nums.length - 1;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (n < o) {
                List<Integer> list = new ArrayList<>();
                if ((nums[m] + nums[n] + nums[o]) < 0) {
                    n++;

                } else if ((nums[m] + nums[n] + nums[o]) > 0) {
                    o--;
                } else if ((nums[m] + nums[n] + nums[o]) == 0) {
                    list.add(nums[m]);
                    list.add(nums[n]);
                    list.add(nums[o]);
                    result.add(list);
                    n++;
                    while (nums[n] == nums[n - 1] && n < o) {
                        n = n++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        ThreeSum three = new ThreeSum();
            System.out.println(three.threeSum(num));
    }
}
