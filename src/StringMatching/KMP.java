package StringMatching;

public class KMP implements StringMatcher{

    public int[] preProcess(String p){
        int[] pi = new int[p.length()+1];
        pi[1]=0;
        int k=0;
        for(int i=2;i<p.length()+1;i++){
            while (k>0 && p.charAt(k)!=p.charAt(i-1)){
                k = pi[k];
            }
            if (p.charAt(k)==p.charAt(i-1)){
                k++;
            }
            pi[i]=k;
        }
        return pi;
    }

    @Override
    public void matchString(String t, String p) {
        int[] pi = preProcess(p);
        int k = 0;
        int i = 0;
        while (i<t.length()){
            while (k>0&&p.charAt(k)!=t.charAt(i)){
                k=pi[k];
            }
            if (p.charAt(k)==t.charAt(i)){
                k++;
            }
            if (k==p.length()){
                System.out.println(String.format("Matching found at shift %d !",i-p.length()+1));
                k=pi[k];
            }
            i++;

        }

    }

    public static void main(String... args){
        KMP main = new KMP();
        String test = "abbabbabbabbabbabbbbaabbabbabb";
        String target = "abbabb";
        main.matchString(test,target);
    }
}
