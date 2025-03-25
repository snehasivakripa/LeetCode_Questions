package Array;

import java.util.HashMap;
import java.util.Map;

public class IdentifyOutliers {

    public int getLargestOutlier(int[] nums) {
        int total = 0;
        int outlier=Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            total += n;
        }
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums) {
            total=total-n;
            map.replace(n,map.get(n)-1);
            if(total%2==0 && map.containsKey(total/2) && map.get(total/2)>0){
                outlier=Math.max(outlier,n);
            }
            total=total+n;
            map.replace(n,map.get(n)+1);
        }
        return outlier;
    }


    public static void main(String[] args) {
        int[] arr={-2,-1,-3,-6,4};
        IdentifyOutliers identifyOutliers=new IdentifyOutliers();
        System.out.println(identifyOutliers.getLargestOutlier(arr));
    }
}
