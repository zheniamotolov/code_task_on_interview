import java.util.Arrays;

public class QuickSort {

    public static int pointer1(int[] arr, int l, int r) {
        int p = arr[l + (r - l) / 2];
        while (l <= r) {
            while (arr[l] < p) {
                l++;
            }
            while (arr[r] > p) {
                r--;
            }
            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        return l;
    }
    public static void quickSort1(int arr[], int l, int r) {
        if (l < r) {
            int p = pointer1(arr, l, r);
            quickSort1(arr, l, p - 1);
            quickSort1(arr, p + 1, r);
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }

    private static void quickSort2(int[] arr, int l, int r) {
        if (l < r) {
            int p = pointer2(arr, l, r);
            quickSort2(arr, l, p - 1);
            quickSort2(arr, p + 1, r);
        }
    }

    private static int pointer2(int[] arr, int l, int r) {
        int p = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < p) {
                i++;
                swap(arr, i, j);
            }
        }
        i += 1;
        swap(arr, i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 6, 8, 13, 24, 5, 9};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
