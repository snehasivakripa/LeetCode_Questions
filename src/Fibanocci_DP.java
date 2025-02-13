public class Fibanocci_DP {


    private int fibanocci(int n) {

        int[] dp=new int[n+1];
        if(n==1||n==2){
          return 1;
        }
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
           dp[i]= dp[i-1]+dp[i-2];
        }

        return dp[n];

    }


    public static void main(String[] args) {
        int n=8;
        Fibanocci_DP fib=new Fibanocci_DP();
        System.out.println(fib.fibanocci(n));
    }
}
