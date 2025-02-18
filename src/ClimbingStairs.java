public class ClimbingStairs {

    private int climbStairs(int n) {
        int[] arr=new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<=n;i++){
          arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

//    public int climbStairs(int n) {
//        int[] arr= new int[n+1];
//        arr[0]=1;
//        for(int i=1;i<=n;i++) {
//            for (int coin : new int[]{1,2}) {
//                int remain = i - coin;
//                if (remain < 0) {
//                    continue;
//                } else
//                {arr[i] = arr[i] + arr[remain];}
//            }
//        }
//        return arr[n];
//    }
        public static void main(String[] args) {
        int n=5;
        ClimbingStairs climb=new ClimbingStairs();
        System.out.println(climb.climbStairs(n));
    }


}
