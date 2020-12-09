class Scratch {
    public static void main(String[] args) {
        
    }

    public int solution(int[] A) {
        // write your code in Java SE 11

        int result = 0;
        // moving forward
        for (int i = 0;i<A.length;i++) {

            if (i+A[i]<=A.length-1) {
                result+=A[i];
            } else {
                result=A.length-i-1;
            }

        }

        for (int i = 0; i < A.length;i++) {

        }

        return result;
    }
}