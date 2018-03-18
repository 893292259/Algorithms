public class LongestSubsequence {
    public static void main (String... args){
        int[] x ={1,4,2,3};
        int[] y ={1,2,3,4};
        int[][] solution = new int[4][4];
        boolean flag = false;

        for (int j=0;j<4;j++){
            if (flag){
                solution[0][j]=1;
            }
            else if (x[0]==y[j]){
                solution[0][j]=1;
                flag = true;
            }
            else{
                solution[0][j]=0;
            }
        }

        for (int i=1;i<4;i++){
            for (int j=0; j<4;j++){
                int test1 = solution[i-1][j];
                int test2 = 0;
                flag = false;
                int k;
                for (k=j;k>=0;k--){
                    if (x[i]==y[k]){
                        break;
                    }
                }
                if (k==0){
                    test2 = 1;
                }
                else if (k>0){
                    test2 = solution[i-1][k-1]+1;
                }
                solution[i][j] = test1>test2 ? test1:test2;
            }
        }
        System.out.println(solution[3][3]);
    }
}
