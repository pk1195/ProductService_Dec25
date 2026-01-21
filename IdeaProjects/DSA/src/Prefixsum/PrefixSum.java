package Prefixsum;

public class PrefixSum {

    //Given array A, answer sum queries in range [L, R]
    public int[] prefixSumAray(int[] arr){
        int n = arr.length;
        int pSum[] = new int[n];
      //  pSum[0] = arr[0];
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum = sum + arr[i];
            pSum[i] = sum;
        }
        return pSum;
    }

    public static void main() {
        int arr[] = {1, 2, 3, 4, 5};
        PrefixSum ps = new PrefixSum();
        int pSum[] = ps.prefixSumAray(arr);
        for (int i = 0; i < pSum.length; i++) {
            System.out.print(pSum[i] + " ");
        }
    }
}
