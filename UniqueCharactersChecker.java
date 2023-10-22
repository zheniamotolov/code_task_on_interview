import java.util.HashMap;
import java.util.HashSet;

public class UniqueCharactersChecker {

    static boolean check(String str){
        HashSet<Character> set = new HashSet<>();
        for(Character c:str.toCharArray()){
            if(set.contains(c.toString())){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        String str ="sfds";
        System.out.println(check(str));
    }
}
