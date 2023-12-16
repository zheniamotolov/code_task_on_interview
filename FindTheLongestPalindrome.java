import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTheLongestPalindrome {
    public static void main(String[] args) {
    ArrayList<Integer> kek= new ArrayList<>();
    kek.add(4);
    kek.add(2);
    Collections.sort(kek);
        System.out.println(kek.get(0));
    }
    public String longestPalindrome(String str) {
        if(str.isEmpty()){
            return str;
        }
        String longestPalindrome="";
        for(int i=0;i<str.length();i++){
            // for uneven cases
            String palindrome= expandAroundCenter(str,i,i);
            if(palindrome.length()>longestPalindrome.length()){
                longestPalindrome= palindrome;
            }
            String palindromeEven = expandAroundCenter(str,i,i+1);
            if(palindromeEven.length()>longestPalindrome.length()){
                longestPalindrome= palindromeEven;
            }

        }
        return longestPalindrome;
    }

    String expandAroundCenter(String str, int i, int j){
        while(i>=0&&j<str.length()&&str.charAt(i)==str.charAt(j)){
            i--;
            j++;

        }
        return str.substring(i+1,j);

    }
}
