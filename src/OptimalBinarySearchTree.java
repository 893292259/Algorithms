public class OptimalBinarySearchTree {
    public static void main(String... args){
        double[] p = {0.1,0.1,0.1,0.1};
        double[] q = {0.1,0.2,0.1,0.1,0.1};

        double[][] pscan = new double[4][4];
        double[][] qscan = new double[5][5];

        for (int i=0;i<4;i++){
            for (int j=i;j<4;j++){
                if (i==j){
                    pscan[i][j] = p[i];
                }
                else {
                    pscan[i][j] = pscan[i][j-1]+p[j];
                }
            }
        }

        for (int i=0;i<5;i++){
            for (int j=i;j<5;j++){
                if (i==j){
                    qscan[i][j] = q[i];
                }
                else {
                    qscan[i][j] = qscan[i][j-1]+q[j];
                }
            }
        }



        double[][] result = new double[4][4];
        double[][] impl = new double[4][4];

        for (int i=0;i<4;i++){
            result[i][i]=(p[i]+2*(q[i]+q[i+1]))/(p[i]+q[i]+q[i+1]);
            impl[i][i]=i;
        }
        for (int j=1;j<4;j++){
            for (int i=0; i+j<4; i++){
                result[i][i+j]=1000;
                double probability = pscan[i][i+j]+qscan[i][i+j+1];
                double temp;
                for (int k=i;k<=i+j;k++){
                    if (k==i){
                        temp = ((result[i+1][i+j]+1)*(pscan[i+1][i+j]+qscan[i+1][i+j+1])+p[i]+2*q[i])/probability;
                    }
                    else if (k==i+j){
                        temp = ((result[i][i+j-1]+1)*(pscan[i][i+j-1]+qscan[i][i+j])+p[i+j]+2*q[i+j+1])/probability;
                    }
                    else {
                        temp = ((result[i][k-1]+1)*(pscan[i][k-1]+qscan[i][k])+(result[k+1][i+j]+1)*(pscan[k+1][i+j]+qscan[k+1][i+j+1])+p[k])/probability;
                    }
                    if (temp<result[i][i+j]) {
                        result[i][i+j] = temp;
                        impl[i][i+j]=k;
                    }
                }
            }
        }
        System.out.println(result[0][3]);
        }
    }
