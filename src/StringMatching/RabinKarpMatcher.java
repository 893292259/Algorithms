package StringMatching;

public class RabinKarpMatcher {
    public void stringMatching (String t,String p){
        int d=0;
        int target=0;
        int i;
        int radix = 26;
        int q = 13;
        int h =(int) Math.pow(radix,p.length()-1)%q;
        for (i=0;i<p.length();i++){
            target = (target*radix+(p.charAt(i)-97))% q;
            d = (d*radix+(t.charAt(i)-97))% q;
        }
        for (i=0; i<t.length()-p.length()+1;i++) {
            if (target==d){
                if (t.substring(i,i+p.length()).equals(p)){
                    System.out.println(String.format("Matching found at shift %d !",i));
                }
            }
            if (i<t.length()-p.length()){
                d = ((radix*(d-(t.charAt(i)-97)*h)+t.charAt(i+p.length())-97)%q+q)%q;
            }
        }
    }

    public static void main (String... args){
        String test = "sddadsddads";
        String target = "sddads";
        RabinKarpMatcher main = new RabinKarpMatcher();
        main.stringMatching(test,target);
    }
}
