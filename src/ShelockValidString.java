import java.util.*;
import java.util.stream.Collectors;

public class ShelockValidString {

    public String isValid(String s) {
        // Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : map.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        if (freqCount.size() == 1) {
            return "YES";
        }
        if (freqCount.size() == 2) {

            Set<Integer> keys = freqCount.keySet();
            int maxKey = Collections.max(keys);
            int minKey = Collections.min(keys);
            if(Math.abs(maxKey-minKey)>1 && freqCount.get(maxKey)<=freqCount.get(minKey)){
                return "NO";
            }

            int min=Integer.MAX_VALUE;
            for(int n:freqCount.keySet()){

                if(min>freqCount.get(n)){
                    min=n;
                }
            }

            if(freqCount.get(min)>1){
                return "NO";
            }
        }
        if (freqCount.size() > 2) {
            return "NO";
        }

        return "YES";
    }

public static void main(String[] args){
        String str="aaaabbcc";
        ShelockValidString sherlock=new ShelockValidString();
        System.out.println(sherlock.isValid(str));

}
}
