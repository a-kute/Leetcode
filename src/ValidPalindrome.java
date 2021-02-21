import java.util.ArrayList;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String current = s.toLowerCase();
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i< s.length(); i++) {
            char cur = current.charAt(i);
            if(Character.isLetterOrDigit(cur)) {
                list.add(cur);
            }
        }
        int start = 0;
        int end = list.size()-1;
        while(start<end) {
            if(list.get(start) != list.get(end)) return false;
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("abca"));
    }
}
