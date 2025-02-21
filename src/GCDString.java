public class GCDString {

    public String GCD(String word1, String word2) {
        if(!(word1+word2).equals(word2+word1)){
            return "";
        }
       return word1.substring(0,gcd(word1.length(),word2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        String word1="ABCAABCAABCA";
        String word2="ABCA";
        GCDString gcd=new GCDString();
        System.out.println(gcd.GCD(word1,word2));
    }
}
