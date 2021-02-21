import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> set = new HashMap<Character,Integer>();
        int max = 0;
        int pointer1 = 0;
        for(int i = 0; i< s.length(); i++) {
            set.put(s.charAt(i),set.getOrDefault(s.charAt(i),0)+1);
            while(set.size()<(i-pointer1+1)&&pointer1<i) {
                if(set.get(s.charAt(pointer1))==1) set.remove(s.charAt(pointer1));
                else set.put(s.charAt(pointer1),set.get(s.charAt(pointer1))-1);
                pointer1++;
            }
            if(i-pointer1+1>max) max =i-pointer1+1;
        }
        return max;

    }
    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));

    }
}
