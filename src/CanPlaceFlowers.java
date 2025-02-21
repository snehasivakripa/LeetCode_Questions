public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                boolean left=(i==0)||(flowerbed[i-1]==0);
                boolean right=(i==flowerbed.length-1)||(flowerbed[i+1]==0);

                if(left&&right){
                    flowerbed[i]=1;
                    n--;
                }
                if(n==0){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] bed= {1,0,0,0,0,1};
        int plant=2;
        CanPlaceFlowers place=new CanPlaceFlowers();
        System.out.println(place.canPlaceFlowers(bed,plant));
    }
}
