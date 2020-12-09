import java.util.HashMap;
import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        int[] A = new int[]{1, 2, 1, 1, 2, 1};
        System.out.println(scratch.solution(A));
    }

    public int solution(int[] A) {

        int leader = 0;
        int answer = 0;
        int leaderAmount = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        int max = 0;
        for (int i = 0; i< A.length;i++) {
            if (frequency.containsKey(A[i])) {
                frequency.put(A[i], frequency.get(A[i])+1);
            } else {
                frequency.put(A[i], 1);
            }

            if (frequency.get(A[i]) > max) {
                max = frequency.get(A[i]);
                leader = A[i];
            }
        }

        leaderAmount = frequency.get(leader);

        if ( leaderAmount > A.length*0.5) {

            int leftLeaderCount = 0;
            int rightLeaderCount = 0;
            for (int i = 0; i< A.length;i++) {

                if (A[i] == leader) {
                    leftLeaderCount++;
                }

                if (leftLeaderCount > (i+1)*0.5) {
                    rightLeaderCount = leaderAmount - leftLeaderCount;

                    if (rightLeaderCount > (A.length-i-1)*0.5) {
                        answer++;
                    }
                }

            }
        }

        return answer;

    }
}
//1,2,2,2
//        1,2,2,2,1
//        2,1,2,2
//        2,2,1,2
//        2,2,2,1
//        0,0
//        7
//        -1000000000,-1000000000,-1000000000