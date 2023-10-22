//Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
//
//        Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
//
//
//
//        Example 1:
//
//        Input: arr = [1,0,2,3,0,4,5,0]
//        Output: [1,0,0,2,3,0,0,4]
//        Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
//        Example 2:
//
//        Input: arr = [1,2,3]
//        Output: [1,2,3]
//        Explanation: After calling your function, the input array is modified to: [1,2,3]


public class LeftRotationWithZeroDublication {
    public static void main(String[] args) {

    }

    public void duplicateZeros(int[] arr) {
        int dubZeros = 0;
        int _length = arr.length - 1;

        for (int i = 0; i <= _length - dubZeros; i++) {
            if (arr[i] == 0) {
                //corner case
                if (i == _length - dubZeros) {
                    arr[_length] = 0;
                    _length -= 1;
                    break;
                }
                dubZeros++;

                // Copy zero twice, and non zero once.
            }
        }
        for (int i = _length - dubZeros; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + dubZeros] = 0;
                dubZeros--;
                arr[i + dubZeros] = 0;
            } else {
                arr[i + dubZeros] = arr[i];
            }
        }
    }

}
