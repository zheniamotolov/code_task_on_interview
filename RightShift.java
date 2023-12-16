import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RightShift {
    public static void main(String[] args) {
        int kek[] = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 3; i++) {
            int j=kek.length-1;
            int temp=kek[j];
            while (j>0) {
                kek[j] = kek[j-1];
                j--;
            }
            kek[0]=temp;
        }
        System.out.println(Arrays.toString(kek));
    }

    public static void leftShift(String[] args) {
        int kek[] = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 3; i++) {
            int j=0;
            int temp=kek[j];
            while (j<kek.length-1) {
                kek[j]=kek[j+1];
                j++;
            }
            kek[kek.length-1]=temp;
        }
        System.out.println(Arrays.toString(kek));
    }
}
