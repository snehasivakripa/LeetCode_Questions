public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index=0;
        for(int n:nums){
            if(n!=0){
                nums[index++]=n;
            }
        }
        while(index<nums.length){
            nums[index++]=0;
        }

        for(int n:nums){
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        MoveZeroes move=new MoveZeroes();
        move.moveZeroes(nums);
    }
}
