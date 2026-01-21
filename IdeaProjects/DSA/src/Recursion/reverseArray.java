package Recursion;

public class reverseArray {

    public int[] reverseArr(int arr[], int p1, int p2){
        int n = arr.length;
        int out[] = new int[n];

         //base case
        if(p1 >= p2)
            return  arr;

        //swap
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;

        //recursive call
        return reverseArr(arr,p1+1,p2-1);
    }

    public static void main(String[] args) {
        reverseArray ra = new reverseArray();
        int arr[] = {1, 2, 3, 4, 5};
        ra.reverseArr(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
