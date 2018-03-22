package StringMatching;

import java.util.HashMap;
import java.util.Map;

public class StringMatchingAutomata {

    public int[][] preProcess(String p){
        int[][] map = new int[p.length()+1][26];
        for (int q=0;q<=p.length();q++){
            for (char a =97;a<97+26;a++) {
                int k = Math.min(q + 1, p.length());
                String Pqa = new StringBuilder().append(p.substring(0,q)).append(a).toString();
                String Pk = p.substring(0,k);
                while (k>0&&!Pk.equals(Pqa.substring(Pqa.length()-k,Pqa.length()))){
                    k--;
                    Pk = p.substring(0,k);
                }
                map[q][a-97] = k;
            }
        }
        return map;
    }

    public void matchString (String t,String p) {
        int[][] delta = preProcess (p);
        int currentState = 0;
        for (int i=0;i<t.length();i++){
            currentState = delta[currentState][t.charAt(i)-97];
            if (currentState==p.length()){
                System.out.println(String.format("Match found at shift %d!",i-p.length()+1));
            }
        }
    }

    public static void main (String... args){
        String test = "sddadsddads";
        String target = "sddads";
        StringMatchingAutomata main = new StringMatchingAutomata();
        main.matchString(test,target);
    }
}
