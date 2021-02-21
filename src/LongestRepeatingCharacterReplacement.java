import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int changeLoc = 0;
        int pointer1 = 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int max = 0;
        //set.add(s.charAt(0));

        for(int i = 0; i<s.length();i++) {
            if(set.contains(s.charAt(i))){
                if(i-pointer1+1>max) max = i-pointer1+1;
            }else{
                if(count == 0) {
                    changeLoc = i;
                }
                count++;
                if(count>k) {
                    set.add(s.charAt(i));
                }
            }
            if(set.size()>1) {
                pointer1 = changeLoc;
                i = changeLoc+1;
                count=0;
                set = new HashSet<>();
                if(i<s.length())
                set.add(s.charAt(i));
            }

            if(i-pointer1+1>max) max = i-pointer1+1;
        }
        return max;

    }
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA",1));
    }
}
