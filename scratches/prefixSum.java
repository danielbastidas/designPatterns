import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        String s = "CAGCCTA";
        int[] p = new int[]{2,5,0};
        int[] q = new int[]{4,5,6};
        IntStream.of(scratch.solution(s,p,q)).forEach(value->System.out.println(value));
    }

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 11
        int M = P.length;
        int[] solution = new int[M];
        int[][] prefixSum = new int[3][S.length()+1];
        short a = 0, c = 0, g = 0;

        for (int i=0;i<S.length();i++) {
            a = 0; c = 0; g = 0;

            switch (S.charAt(i)) {
                case 'A': a=1;
                    break;
                case 'C': c=1;
                    break;
                case 'G': g=1;
                    break;
                default: break;
            }

            prefixSum[0][i+1] = prefixSum[0][i]+a;
            prefixSum[1][i+1] = prefixSum[1][i]+c;
            prefixSum[2][i+1] = prefixSum[2][i]+g;

        }

        for (int i = 0; i< M;i++) {
            int fromIndex = P[i];
            int toIndex = Q[i]+1;

            if (prefixSum[0][toIndex] - prefixSum[0][fromIndex] > 0) {
                // there are letters A in that range so that is the answer
                solution[i] = 1;
            } else if (prefixSum[1][toIndex] - prefixSum[1][fromIndex] > 0) {
                // there are letters C in that range so that is the answer
                solution[i] = 2;
            } else if (prefixSum[2][toIndex] - prefixSum[2][fromIndex] > 0) {
                // there are letters G in that range so that is the answer
                solution[i] = 3;
            } else {
                // there are letters T in that range so that is the answer
                solution[i] = 4;
            }

        }

        return solution;
    }
}