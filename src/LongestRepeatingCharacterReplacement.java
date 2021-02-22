import java.util.HashMap;
import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int mostCommon =0;
        int max = 0;
        int end = 0;
        int start = 0;
        mostCommon = 0;
        map = new HashMap<>();
        while(end<s.length()) {
                char current = s.charAt(end);
                map.put(current,map.getOrDefault(current,0)+1);
                int ma = 0;
                for(char key : map.keySet()) {
                    if(map.get(key)>ma) {
                        ma = map.get(key);
                    }
                }
                mostCommon = ma;
                if(end-start+1-mostCommon>k){
                    map.put(s.charAt(start),map.getOrDefault(s.charAt(start),1)-1);
                    start++;
                    end++;
                } else {
                    if(end-start+1 > max) max = end-start+1;
                    end++;
                }


        }
        return max;

    }
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA",1));
    }
}
