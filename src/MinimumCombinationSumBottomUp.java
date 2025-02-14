public class MinimumCombinationSumBottomUp {


    public int minimumCombinationBU(int[] nums, int target) {
        int[] arr=new int[target+1];
        arr[0]=0;
            for(int i=1;i<=target;i++) {
                for (int coin : nums) {
                    int remain = i - coin;
                    if (remain < 0) {
                        continue;
                    } else arr[i]=findMin(arr[i],arr[remain]+1);
                }
            }


        return arr[target];
    }

    private int findMin(int a, int b) {
        if(a==0) return b;
        else if(b==0) return a;
        else return Math.min(a,b);
    }

    public static void main(String[] args) {
        int[] coins={1,4,5};
        int target=13;
        MinimumCombinationSumBottomUp minBU=new MinimumCombinationSumBottomUp();
        System.out.println(minBU.minimumCombinationBU(coins,target));
    }

}
