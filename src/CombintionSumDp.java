public class CombintionSumDp {
    public int combinationDp(int[] nums, int target) {
        int[] arr= new int[target+1];
        if(arr[target]!=0){
            return arr[target];
        }
        int count=0;
        if (target==0){ count=0;}
        else{
            for(int coin:nums){
                int remain=target-coin;
                if(remain<0){continue;}
                else if(remain==0){ count++;}
                else count=count+combinationDp(nums,remain);
                arr[target]=count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins={1,2,3};
        int target=4;
        CombintionSumDp combDp=new CombintionSumDp();
        System.out.println(combDp.combinationDp(coins,target));
    }
}
