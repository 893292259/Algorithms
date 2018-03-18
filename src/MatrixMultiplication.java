public class MatrixMultiplication {

    public static void main(String[] args){
        int[] lengths = {4,2,3,4,2,12,23};
        int[][] minimum = new int[7][7];
        int[][] procedure= new int[7][7];
        for (int i=0; i<6; i++ ){
            for (int j=1; j+i<7;j++){
                if (i==0){
                    minimum[j][j+i] = 0;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    int probe = 0;
                    for (int k=j;k<j+i;k++){
                        if (minimum[j][k]+minimum[k+1][j+i]+lengths[j-1]*lengths[k]*lengths[j+i]<min){
                            min = minimum[j][k]+minimum[k+1][j+i]+lengths[j-1]*lengths[k]*lengths[j+1];
                            probe = k;
                        }
                    }
                    minimum[j][j+i]=min;
                    procedure[j][j+i]= probe;
                }
            }
        }
        System.out.println(minimum[1][6]);
    }
}
