import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        String test = "{  }   [   []]";
        System.out.println(check(test));

        Stack<Integer> stack = new Stack<>();
        stack.size();

    }

    public static boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : str.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stack.isEmpty()) {
                    return false;  // There is no matching opening bracket
                }

                char openingBracket = stack.pop();
                if (!isMatchingPair(openingBracket, bracket)) {
                    return false;  // Opening and closing brackets do not match
                }
            }
        }

        // If the stack is empty, all brackets have been matched
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}

