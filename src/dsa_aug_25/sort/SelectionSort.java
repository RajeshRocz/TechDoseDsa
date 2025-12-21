package dsa_aug_25.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] a=new int[]{3,2,6,4,9,7,8};
        System.out.println("Before Sort");
        Arrays.stream(a).forEach(n->System.out.print(n+" "));
        selectionSort(a);
        System.out.println("\nAfter Sort");
        Arrays.stream(a).forEach(n->System.out.print(n+" "));
    }

    public static void selectionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(a[minIndex]>a[j]){
                    minIndex=j;
                }
            }
            if(i!=minIndex){
                int t=a[i];
                a[i]=a[minIndex];
                a[minIndex]=t;
            }
        }
    }
}
