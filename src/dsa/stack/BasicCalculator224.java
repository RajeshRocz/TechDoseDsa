package dsa.stack;

import java.util.Stack;

/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
 */

public class BasicCalculator224 {
    public static void main(String[] args) {
        System.out.println("(1+(4+5+2)-3)+(6+8)");
        calculate("(1+(4+5+2)-3)+(6+8)");
    }
    public static int calculate(String s) {

        StringBuilder postFix=new StringBuilder();
        Stack<Character> stack=new Stack<>();

        for(char c:s.toCharArray()){
            if(c==' '){
                continue;
            }
            if(c >='0' && c<='9'){
                postFix.append(c);
            }else {
                if(stack.isEmpty() || c=='('){
                    stack.push(c);
                } else if (c==')') {
                    while(stack.peek()!='('){
                        postFix.append(stack.pop());
                    }
                    stack.pop();
                    
                }else {
                    while(!stack.isEmpty()){
                        postFix.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()){
            postFix.append(stack.pop());
        }

        System.out.println(postFix);

        return 0;
    }
}
