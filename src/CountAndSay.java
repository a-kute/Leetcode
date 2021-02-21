public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        String current = countAndSay(n-1);
        int count = 1;
        char currents = current.charAt(current.length()-1);
        String result = "";
        for(int i = current.length()-2; i>=0; i--) {

            if(current.charAt(i)!=currents){
                result = String.format("%d%c%s",count,currents,result);
                currents = current.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        result = String.format("%d%c%s",count,currents,result);
        return result;

    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }
}
