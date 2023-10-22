import java.util.ArrayList;
import java.util.List;

public class PhoneCombinations {

/*
Generate all possible words for the given phone number.

Given the standard phone keyboard mapping (picture below)

 1    2    3
     ABC  DEF

 4    5    6
GHI  JKL  MNO

 7    8    9
PQRS TUV  WXYZ

      0


e.g. 1 -> "1", 2 -> "a,b,c", 3 -> "d,e,f" etc. ) we can generate words for a phone number.

For example:
289 can be written as "buy" or "cuz" or "avy" etc.


43556 can be written as "hello" or "gekko" etc.

*/


    private static final List<List<Character>> LETTERS = List.of(
            List.of('0'),
            List.of('1'),
            List.of('a', 'b', 'c'),
            List.of('d', 'e', 'f'),//3
            List.of('g', 'h', 'i'),//4
            List.of('j', 'k', 'l'),//5
            List.of('m', 'n', 'o'),//6
            List.of('p', 'q', 'r', 's'),
            List.of('t', 'u', 'v'),
            List.of('w', 'x', 'y', 'z')
    );

    public List<String> phoneNumberWords(String phoneNumber) {
        List<String> combinationsList = new ArrayList<>();
        char numberArray[] = phoneNumber.toCharArray();
        String combination = new String();
        int j = 0;

        for (int i = 0; i < LETTERS.size(); i++) {
            //    List<Character> row = LETTERS.get(Integer.valueOf(String.valueOf(ch)));
            for (j = 0; j < LETTERS.get((int) numberArray[i]).size(); j++) {
                combination += LETTERS.get((int) numberArray[i]);
                break;
            }


            //    for(Character rowCharacter : row){
            //       combination += rowCharacter.toString();
            //    }
            //    ghi
            // ghi *def  = 9
            //gd, ge, gf
            //hd, he, hf
            //id, ie, if
            //    ar[0][i] + ar[1][i] +ar[1][i] ..... n timer


        }
        return null;
        // 3*3*3*3*3 =O(3^stringNumber.length())  = O(3^N)
        //implement
    }


    public static void main(String[] args) {
//        System.out.println(new Solution().phoneNumberWords("43556"));
    }

}


