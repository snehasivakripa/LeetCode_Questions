public class MinimumCombinationSumDP {


    public int minimumCombinationDp(int[] nums, int target) {
        int[] arr=new int[target+1];
        if(arr[target]!=0){
            return arr[target];
        }
        int minimum=0;
        if (target==0){ minimum=0;}
        else{
            for(int coin:nums){
                int remain=target-coin;
                if(remain<0){continue;}
                else minimum=findMin(minimum,minimumCombinationDp(nums,remain)+1);
                arr[target]=minimum;
            }
        }

        return minimum;
    }

    private int findMin(int a, int b) {
        if(a==0) return b;
        else if(b==0) return a;
        else return Math.min(a,b);
    }

    public static void main(String[] args) {
        int[] coins={1,4,5};
        int target=13;
        MinimumCombinationSumDP minDp=new MinimumCombinationSumDP();
        System.out.println(minDp.minimumCombinationDp(coins,target));
    }
}
