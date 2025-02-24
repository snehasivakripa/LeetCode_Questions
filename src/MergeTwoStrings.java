import java.util.Arrays;

public class MergeTwoStrings {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder s=new StringBuilder();
        int len1=word1.length();
        int len2=word2.length();
        int i=0;
        while (i<len1&& i<len2){
            s.append(word1.charAt(i));
            s.append(word2.charAt(i));
            i++;
        }

        if(i<len1){
            s.append(word1.substring(i));
        }else if(i<len2){
            s.append(word2.substring(i));
        }

        return s.toString();
    }

    public static void main(String[] args) {
       String word1="abc";
       String word2="pqrstuvw";
        MergeTwoStrings merge=new MergeTwoStrings();
        System.out.println(merge.mergeAlternately(word1,word2));
    }
}
