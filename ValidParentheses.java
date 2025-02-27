package org.example;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        // the stack puts the symbols in the order that is punctually correct.
        // the most inner parenthesis must have it's match as the next char
        // or else it is invalid. the stack works for this because the most inner
        // char will always be on top. all that is left is to check if the top character
        // actually matches what is in the stack
        Stack<Character> stack = new Stack<Character>();

        // use a 1D array to store chars in the string
        for(char c: s.toCharArray()) {
            // when a left parenthesis is read, the
            // right parenthesis is pushed to the stack
            if (c == '('){
                stack.push(')');
                // if the next char is not a match or another left parenthesis,
                // the result is false
            } else if (c == '{'){
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
