import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaxVowels {

    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        max = count;

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            // Remove the effect of the character going out of the window
            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }
            if (vowels.contains(s.charAt(i))) {
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        String str="abciidef";
        int k=3;
        MaxVowels max=new MaxVowels();
        System.out.println(max.maxVowels(str,k));
    }
}
