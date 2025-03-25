package SlidingWindow;

public class MaximizeConfusionExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
       return Math.max(count(answerKey,k,'T'),count(answerKey,k,'F'));

    }

    private int count(String answerKey, int k, char t) {
        int i=0,j=0,ct=0,ans=0;
        while(j<answerKey.length()){
            if(answerKey.charAt(j)==t){
                ct++;
                while (i<answerKey.length() && ct>k){
                    ct--;
                    i++;
                }
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args){
        String str="TFFFT";
        int k=1;
        MaximizeConfusionExam max=new MaximizeConfusionExam();
        System.out.println(max.maxConsecutiveAnswers(str,k));
    }
}
