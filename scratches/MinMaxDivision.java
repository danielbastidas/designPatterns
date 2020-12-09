import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] A = new int[]{5, 3};
        int k = 3;
        int m = 5;
        Scratch scratch = new Scratch();
        System.out.println(scratch.solution(k,m,A));
    }

    public int solution(int K, int M, int[] A) {
        int minSum = 0;
        int maxSum = 0;
        int possibleResult = 0;


        for (int i=0;i<A.length;i++) {
            minSum = Math.max(minSum, A[i]);
            maxSum+=A[i];
        }

        possibleResult = maxSum;

        while (minSum <= maxSum) {
            final int mid = (minSum+maxSum) / 2;
            final boolean ok = checkBlocksDivision(mid, A, K);
            if (ok) {
                maxSum = mid -1;
                possibleResult = mid;
            } else {
                minSum = mid+1;
            }
        }

        return possibleResult;
    }

    public boolean checkBlocksDivision(int possibleResult, int[] A, int K) {

        int numBlocks = K;
        int blockSum = 0;
        boolean valid = true;

        for (int i = 0;i<A.length && valid;i++) {
            blockSum = blockSum+A[i];

            if (blockSum > possibleResult) {
                blockSum=A[i];
                numBlocks--;
            }

            if (numBlocks == 0) {
                valid = false;
            }
        }

        return valid;
    }
}