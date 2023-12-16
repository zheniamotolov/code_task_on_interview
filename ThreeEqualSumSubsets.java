import java.util.Arrays;

public class ThreeEqualSumSubsets {
    public boolean checkArrayCanBeDividedInto3Subsets(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if(sum%3!=0) {
            int sumA = 0;
//            int[] A = new int[10];
            int sumB = 0;
//            int[] B = new int[10];
            int sumC = 0;
            for(int num :nums){
                while(sumA!=sum/3){
                    sumA+=num;
                    sum-=num;
                }
                while(sumB!=sum/3){
                    sumB+=num;
                    sum-=num;
                }
                while(sumC!=sum/3){
                    sumC+=num;
                    sum-=num;
                }
            }
            if((sumA==sumB)&&(sumB==sumC)){
                return true;
            }
        }
        return false;
    }
}
