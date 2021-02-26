import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< t.length();i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int pointer1 = 0;
        int count = 0;
        int minLength=s.length()+1;
        int endIndex = 0;


        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(map.containsKey(currentChar)) {
             map.put(currentChar,map.get(currentChar)-1);
             if(map.get(currentChar)>=0)
             count++;
            }
            if(t.length() == count) {
                while (t.length() == count) {
                    if (i - pointer1 + 1 < minLength) {
                        minLength = i - pointer1 + 1;
                        endIndex = pointer1;
                    }
                    if (map.containsKey(s.charAt(pointer1))) {
                        if (map.get(s.charAt(pointer1)) == 0) count--;
                        map.put(s.charAt(pointer1), map.get(s.charAt(pointer1)) + 1);
                    }
                    pointer1++;
                }

            }
        }
        if(minLength ==s.length()+1) return "";
        else return s.substring(endIndex,endIndex+minLength);

    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        HashMap<Integer,Integer> ma = map;
        map.remove(1);
        System.out.println(map.size());
        System.out.println(ma.size());
    }

}
