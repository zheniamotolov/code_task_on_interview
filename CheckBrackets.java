import com.sun.source.tree.BreakTree;

import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        String test = "{  }   [   []]";
        System.out.println(check(test));

    }

    public static boolean check(String test) {
        Stack<Character> stack = new Stack<>();

        for (Character ch : test.toCharArray()) {
            if (ch.equals('(') || ch.equals('{') || ch.equals('[')) {
                stack.push(ch);
            }
            if(ch.equals(')') || ch.equals('}') || ch.equals(']')){
                Character ch1= stack.pop();
                if(!stack.isEmpty() && ch1.equals(ch)){
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }
}

