public class CombintionSumBU {
    public int combinationBU(int[] nums, int target) {
        int[] arr= new int[target+1];
        arr[0]=0;
        for(int i=1;i<=target;i++) {
            for (int coin : nums) {
                int remain = i - coin;
                if (remain < 0) {
                    continue;
                } else if (remain == 0) {
                    arr[i]+=1;
                } else arr[i] = arr[i] + arr[remain];
            }
        }
        return arr[target];
    }

    public static void main(String[] args) {
        int[] coins={1,2,3};
        int target=4;
        CombintionSumBU combBU=new CombintionSumBU();
        System.out.println(combBU.combinationBU(coins,target));
    }
}
