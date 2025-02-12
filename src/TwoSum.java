import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int x=0,y=0,sec=0;
        for(int i=0;i<nums.length;i++){
            if(x==0) {
                if (nums[i] < target) {
                    x = i;
                    sec = target - nums[i];
                }
            }else{
                if(nums[i]==sec){
                    y=i;
                }
            }

        }
        int[] result={x,y};
        return result;
    }

    public static void main(String[] args) {
        int[] flowerbed = {11,2,11,7,15};
        int n=9;
        TwoSum two=new TwoSum();
        System.out.println(Arrays.toString(two.twoSum(flowerbed,n)));
    }
}
