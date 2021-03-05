import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < tokens.length;i++) {
            String current = tokens[i];
            if(current == "+") {
                stack.push(stack.pop()+stack.pop());
            } else if(current=="-") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if(current == "*") {

                stack.push(stack.pop()*stack.pop());
            } else if(current == "/") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(current));
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String[] a = {"4","13","5","/","+"};
        System.out.println(evaluateReversePolishNotation.evalRPN(a));
    }

}
