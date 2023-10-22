public class PowerOfNumber {
    public static void main(String[] args) {
        int num = 6;
        int power = 7;
        int result=0;
        for (int i = 0; i < power; i++) {
            if(i==0){
            result = num;
            continue;
            }
            result=result*num;
        }
        System.out.println(result);
    }
}
