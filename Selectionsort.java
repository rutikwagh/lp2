		import java.util.*;
import java.lang.*;
public class Selectionsort{
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int i=0;i<n-1;i++){
            int index = i;
            for(int j = i+1; j<n;j++){
                if(a[j] < a[index]){
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;

        }
        for(int i=0;i<n;i++){
         System.out.print(a[i]+" ");
        }
    }
}
