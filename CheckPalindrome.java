public class CheckPalindrome {
    public static void main(String[] args) {
        checkPalindrome("bb".toCharArray());
    }
    static boolean checkPalindrome(char[] str) {
        int i = 0;
        int j = str.length - 1;
        while (j > i) {
            if (str[i++] != str[j--]) {
                return false;
            }
        }
        return true;
    }
}
