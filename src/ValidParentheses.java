import java.util.HashMap;

public class ValidParentheses {

    public boolean isValid(String s) {
        int[][] array = new int[3][1000];
        int count = 0;
        for(int i = 0; i< s.length(); i++) {
            char current = s.charAt(i);

            switch (current) {
                case '(':
                    array[0][count] = 1;
                    count++;
                    break;
                case '[':
                    array[1][count] = 1;
                    count++;
                    break;
                case '{':
                    array[2][count] = 1;
                    count++;
                    break;
                case ')':
                    if(count==0) return false;
                    if(array[0][count-1] == 1){
                        array[0][count-1] = 0;
                        count--;
                    } else return false;
                    break;
                case ']':
                    if(count==0) return false;
                    if(array[1][count-1] == 1){
                        array[1][count-1] = 0;
                        count--;
                    } else return false;
                    break;
                case '}':
                    if(count==0) return false;
                    if(array[2][count-1] == 1){
                        array[2][count-1] = 0;
                        count--;
                    } else return false;
                    break;


            }
        }
        if(count!=0) return false;
        return true;

    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()[]{}"));
    }
}
