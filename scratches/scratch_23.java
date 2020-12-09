import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        
    }
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 11

        int max = 0;
        int[] result = new int[N];
        int lastUpdate = 0;

        for (int  i=0;i < A.length;i++) {
            if (A[i]<=N) {
                if (result[A[i]-1] < lastUpdate) {
                    result[A[i]-1] = lastUpdate+1;
                } else {
                    result[A[i]-1]+=1;
                }
                max = Math.max(max, result[A[i]-1]);
            } else if (A[i]==N+1) {
                lastUpdate = max;
            }
        }

        for (int i = 0; i< N;i++) {
            if (result[i] < lastUpdate) {
                result[i] = lastUpdate;
            }
        }

        return result;

    }
}