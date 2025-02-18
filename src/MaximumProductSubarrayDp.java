public class MaximumProductSubarrayDp {

    private int maxProduct(int[] nums) {
        int maxProd=nums[0];
        int totalProd=1;
        for(int n:nums){
            if(totalProd<0){
                totalProd=1;
            }
            totalProd*=n;
            if(maxProd<totalProd){
                maxProd=totalProd;
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        int[] nums={-2,0,-1};
        MaximumProductSubarrayDp max=new MaximumProductSubarrayDp();
        System.out.println(max.maxProduct(nums));
    }
}
