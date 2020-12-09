import java.util.Arrays;
import java.util.stream.IntStream;

class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        int[] A = new int[]{1,2,3};

        System.out.println(scratch.solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 11

        int answer = 1;
        boolean found = false;
        Arrays.sort(A);

        for (int i=0;i< A.length && !found;i++) {

            if (answer<A[i]) {
                found = true;
            } else if ( i+1<A.length && A[i]!=A[i+1] && A[i]>0) {
                answer++;
            }

        }

        if (found == false) {
            answer = A[A.length-1]+1;
        }

        return answer<=0? 1:answer;
    }
}