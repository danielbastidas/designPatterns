class Scratch {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 4, 8};
        int[] B = new int[]{1000000000, 3, 6, 10};

        Scratch scratch = new Scratch();
        System.out.println(scratch.solution(A, B));
    }
    public int solution(int[] A, int[] B) {

        int count = 1;
        int prev = 0;
        if (A.length == 0) {
            return 0;
        }

        prev = B[0];

        for (int j=1;j<A.length;j++) {
            if (A[j]>prev) {
                count++;
                prev = B[j];
            }
        }

        return count;
    }

}