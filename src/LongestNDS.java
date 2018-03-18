public class LongestNDS {
    public static void main(String... args){
        int[] array = {2,3,4,3,2,1,2,3,4};
        int[] max = new int[array.length];
        int[] longest = new int[array.length];
        max[0] = array[0];
        longest[0] = 1;
        for (int i=1;i<array.length;i++){
            int temp1=1;
            for (int j=i-1; j>=0;j--){
                if (max[j]<=array[i]){
                    temp1=longest[j]+1;
                    break;
                }
            }
            int temp2 = longest[i-1];
            max[i]= temp1>temp2 ? array[i]: max[i-1];
            longest[i] = temp1>temp2? temp1:temp2;
        }
        System.out.println(longest[array.length-1]);
    }
}
