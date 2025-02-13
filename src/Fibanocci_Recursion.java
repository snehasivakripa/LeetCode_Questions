import java.util.Arrays;

public class Fibanocci_Recursion {

    private int fibanocci(int n) {

        int result;
        if(n==1||n==2){
            result=1;
        }else{
            result=fibanocci(n-1)+fibanocci(n-2);
        }
        return result;
    }


    public static void main(String[] args) {
        int n=8;
        Fibanocci_Recursion fib=new Fibanocci_Recursion();
        System.out.println(fib.fibanocci(n));
    }


}
