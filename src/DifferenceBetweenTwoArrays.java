import java.util.*;

public class DifferenceBetweenTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(firstUniqueArray(nums2, nums1),firstUniqueArray(nums1, nums2));
    }

    private static ArrayList firstUniqueArray(int[] nums1, int[] nums2) {
        Set<Integer> uniq1=new HashSet<>();
        Set<Integer> uniq2=new HashSet<>();
        for(int n: nums1){
            uniq1.add(n);
        }
        for(int n: nums2){
            if(!uniq1.contains(n))
             uniq2.add(n);
        }
        return new ArrayList<>(uniq2);
    }


    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={2,4,6};
        DifferenceBetweenTwoArrays diff=new DifferenceBetweenTwoArrays();
        System.out.println(diff.findDifference(nums1,nums2));
    }

}
