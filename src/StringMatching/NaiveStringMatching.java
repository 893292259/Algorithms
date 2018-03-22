package StringMatching;

public class NaiveStringMatching implements StringMatcher {

    public void matchString (String p, String t){
        for (int i=0; i<t.length()-p.length()+1;i++){
            if (t.substring(i,i+p.length()).equals(p)){
                System.out.println(String.format("Matching found at shift %d !",i));
            }
        }

    }

    public static void main(String... args){
        NaiveStringMatching main = new NaiveStringMatching();
        String test = "ssdsadsad";
        String target = "sd";
        main.matchString(target,test);
    }
}
