public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int start=height[0];
        int volume=0;
        int width=0;
        int result=0;
        for(int i=1;i<height.length;i++){
            width++;
            if(start<height[i]){
                volume=start*width;
                start=height[i];
                width--;
            }else{
                volume=height[i]*width;
            }
            if(volume>result){
                result=volume;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater container=new ContainerWithMostWater();
        System.out.println(container.maxArea(height));
    }
}
