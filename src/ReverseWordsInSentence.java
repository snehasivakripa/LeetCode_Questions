public class ReverseWordsInSentence {

    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        String[] words=s.split(" ");
        for(int i= words.length-1;i>=0;i--){
            str.append(words[i]);
            str.append(" ");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str="the sky is    blue";
        ReverseWordsInSentence reverse=new ReverseWordsInSentence();
        System.out.println(reverse.reverseWords(str));
    }
}
