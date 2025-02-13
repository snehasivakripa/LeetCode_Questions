import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_HashMap {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int second=target-nums[i];
            if(map.containsKey(second)){
                return new int[]{map.get(second),i};
            }
            map.put(nums[i],i);
        }

        return new int[]{-1,1};
    }




    public static void main(String[] args) {
        int[] flowerbed = {11,2,11,7,15};
        int n=9;
        TwoSum_HashMap two=new TwoSum_HashMap();
        System.out.println(Arrays.toString(two.twoSum(flowerbed,n)));
    }
}
