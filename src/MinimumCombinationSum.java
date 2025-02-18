public class MinimumCombinationSum {
    public int minimumCombination(int[] nums, int target) {
        int minimum=0;
        if (target==0){ minimum=0;}
        else{
            for(int coin:nums){
                int remain=target-coin;
                if(remain<0){continue;}
                else minimum=findMin(minimum,minimumCombination(nums,remain)+1);
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
        int target=5;
        MinimumCombinationSum min=new MinimumCombinationSum();
        System.out.println(min.minimumCombination(coins,target));
    }
}
