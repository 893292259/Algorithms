public class RadixSort {

    public static void main(String [] args){
      int[] array = {3,2,10,13,24,5,44,12,23,14};
      int index = 10;
      int result = randomizedSelect(array,index,0,9);
      System.out.println(result);
    }

    public static int randomizedSelect(int[] array, int index, int head, int tail){
        if (head==tail) return array[head];
        else{
            int q = partiton(array,head,tail);
            q=q-head+1;
            if (index==q){
                return array[q];
            }
            else if (index<q){
                return randomizedSelect(array,index,head,q+head-2);
            }
            else{
                return  randomizedSelect(array,index-q,q+head,tail);
            }
            }
    }

    public static  int partiton(int[] array, int head, int tail){
            int q=head;
            int p=tail;
            int target = array[head];
            while(q<p){
                if (array[p]<target){
                    int t2 = array[p];
                    int t3 = array[q+1];
                    array[p]=t3;
                    array[q]=t2;
                    q++;
                }
                else{
                    p--;
                }
            }
            return q;
    }
}
