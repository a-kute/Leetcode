class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> answer = new ArrayList<>();
        if(digits.isEmpty())return answer;
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        map.put(2, new ArrayList(List.of("a","b","c")));
        map.put(3, new ArrayList(List.of("d","e","f")));
        map.put(4, new ArrayList(List.of("g","h","i")));
        map.put(5, new ArrayList(List.of("j","k","l")));
        map.put(6, new ArrayList(List.of("m","n","o")));
        map.put(7, new ArrayList(List.of("p","q","r","s")));
        map.put(8, new ArrayList(List.of("t","u","v")));
        map.put(9, new ArrayList(List.of("w","x","y","z")));   
        recursive(digits,map,answer,0,new StringBuilder());
        return answer;
    }
    public void recursive(String digits, HashMap<Integer, ArrayList<String>> map,List<String> answer, int index, StringBuilder sb){
        if(index == digits.length()){
            answer.add(sb.toString());
            return;
        }
        int current = Integer.parseInt(digits.substring(index,index+1));
        ArrayList<String> valid = map.get(current);
        for(String i: valid){
            StringBuilder s = new StringBuilder(sb);
            s.append(i);
            recursive(digits,map,answer,index+1,s);
        }
    }
}