class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        int[] A = new int[]{-1000,-1000};

        System.out.println(scratch.solution(A));
    }

    public int solution(int[] A) {

        int[] sum = new int[A.length];
        int min = Integer.MAX_VALUE;

        for (int i=0;i<A.length;i++) {
            if (i-1<0) {
                sum[i] = A[i];
            } else{
                sum[i]=sum[i-1]+A[i];
            }
        }

        for (int i=1;i<A.length;i++) {

            int a = sum[i]-A[i];
            int b = sum[A.length-1]-a;

            min = Math.min(min, Math.abs(a-b));

        }

        return min;
    }
}