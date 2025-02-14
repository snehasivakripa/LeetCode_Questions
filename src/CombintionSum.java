public class CombintionSum {
    public int combination(int[] nums, int target) {
        int count=0;
        if (target==0){ count=0;}
        else{
            for(int coin:nums){
                int remain=target-coin;
                if(remain<0){continue;}
                else if(remain==0){ count++;}
                else count=count+combination(nums,remain);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins={1,2,3};
        int target=4;
        CombintionSum comb=new CombintionSum();
        System.out.println(comb.combination(coins,target));
    }
}
