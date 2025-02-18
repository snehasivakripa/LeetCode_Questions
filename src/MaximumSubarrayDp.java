public class MaximumSubarrayDp {


    private int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int totalSum=0;
        for(int n:nums){
            if(totalSum<n){
                totalSum=0;
            }
            totalSum+=n;
            if(maxSum<totalSum){
                maxSum=totalSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums={5,4,-1,7,8};
        MaximumSubarrayDp max=new MaximumSubarrayDp();
        System.out.println(max.maxSubArray(nums));
    }


}
