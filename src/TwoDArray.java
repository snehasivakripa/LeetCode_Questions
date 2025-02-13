import java.util.ArrayList;
import java.util.List;

public class TwoDArray {


    public int hourglassSum(List<List<Integer>> arr) {
            // Write your code here
            int result= Integer.MIN_VALUE;

            for(int i=0;i<arr.size()-2;i++){
                for(int j=0;j<arr.get(i).size()-2;j++){
                    int first=arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2);
                    int second=arr.get(i+1).get(j+1);
                    int third=arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
                    int sum=first+second+third;
                    if(result<sum){
                        result=sum;
                    }

                }
            }
            return result;
        }


        public static void main(String[] args) {
            List<List<Integer>> arr = new ArrayList<>();
            arr.add(new ArrayList<>(List.of(0,-4,-6,0,-7,-6)));
            arr.add(new ArrayList<>(List.of(-1,-2,-6,-8,-3,-1)));
            arr.add(new ArrayList<>(List.of(-8,-4,-2,-8,-8,-6)));
            arr.add(new ArrayList<>(List.of(-3,-1,-2,-5,-7,-4)));
            arr.add(new ArrayList<>(List.of(-3,-5,-3,-6,-6,-6)));
            arr.add(new ArrayList<>(List.of(-3,-6,0,-8,-6,-7)));
            TwoDArray twoDArray=new TwoDArray();
            System.out.println(twoDArray.hourglassSum(arr));
        }


}
