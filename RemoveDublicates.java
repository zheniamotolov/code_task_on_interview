import java.util.Stack;
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//        It does not matter what you leave beyond the returned k (hence they are underscores).
public class RemoveDublicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int uniqueCount = 1; // Initialize with 1 since the first element is always unique
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    // Example usage:
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 4, 4, 5};
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println(k); // Output: [1, 2, 3, 4, 5], k = 5
    }
}
