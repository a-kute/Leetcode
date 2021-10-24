class Solution {
    public int firstUniqChar(String s) {
        char[] arr = new char[26];
        for(int i = 0; i< s.length();i++) {
            char current = s.charAt(i);
            arr[current-'a']+=1;
        }
        for(int i = 0; i< s.length();i++) {
            char current = s.charAt(i);
            if(arr[current-'a']==1) return i;
        }
        return -1;
    }
}