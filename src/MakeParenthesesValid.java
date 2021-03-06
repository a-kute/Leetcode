import java.util.Stack;

public class MakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< S.length(); i++) {
            char current = S.charAt(i);
            if(current=='(') {
                stack.push(current);
                continue;
            }
            else {
                if(stack.size()>0) {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        return stack.size()+count;

    }
}
