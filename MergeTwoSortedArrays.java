import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1= new int[]{0};
        int[] nums2= new int[]{};
        merge(nums1, 0, nums2, 0);
        Arrays.stream(nums1).forEach(x -> System.out.print(x + " "));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i=m-1;
            int j=n-1;
            int k=m+n-1;
            for(;j>=0;){
                if(i>=0 && nums1[i]>nums2[j]){
                    nums1[k--]=nums1[i--];
                } else{
                    nums1[k--]=nums2[j--];
                }
            }

    }
}
