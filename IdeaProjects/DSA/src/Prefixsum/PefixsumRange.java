package Prefixsum;

public class PefixsumRange {

    public int rangeSum(int pSum[], int L, int R){
        if(L==0) {
            return pSum[R];
        }
        else{
            return pSum[R] - pSum[L-1];
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4,5,6};
        PefixsumRange ps = new PefixsumRange();
        PrefixSum pfs = new PrefixSum();
        int pSum[] = pfs.prefixSumAray(arr);
        int L = 2;
        int R = 5;
        int result = ps.rangeSum(pSum, L, R);
        System.out.println("Sum in range [" + L + ", " + R + "] is: " + result);
    }

}
