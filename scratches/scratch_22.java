class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        System.out.println(scratch.solution(new int[]{-2147483648,
                -2147483648, 2147483647, 2147483647}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 11

        int[] dp = new int[A.length];
        dp[0] = A[0];
        int max = Math.max(-Integer.MAX_VALUE, dp[0]);

        for (int i = 1; i< A.length;i++) {
            dp[i] = Math.max(A[i]+A[i-1],dp[i-1]+A[i]);
            max = Math.max(max, dp[i]);
        }

        return max;

    }
}