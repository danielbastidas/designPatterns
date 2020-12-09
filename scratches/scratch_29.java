import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Scratch {

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        int[] A = new int[]{1,15,10,5,6,8,20,2};
        int[] B = new int[]{0,1,1,1,0,0,0,1};
    }

    public int solution(int[] A, int[] B) {

        int numAlive = A.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i< A.length;i++) {
            if (B[i] == 1) {
                stack.push(A[i]);
            } else {
                while (!stack.isEmpty()) {

                    if (stack.peek() > A[i]) {
                        numAlive--;
                        break;
                    } else {
                        numAlive--;
                        stack.pop();
                    }

                }
            }
        }

        return numAlive;
    }
}
//([4,3,2,1,5,6,7],[0,1,0,0,0,1,0])
//([4,3,2,1,5,6,7],[0,0,0,0,0,0,0])
//([4,3,2,1,5,6,7],[1,1,1,1,1,1,1])
//([7,6,5,4,3,2,1],[1,0,0,0,0,0,0])
//([1,2,3,4,5,6,7],[0,0,0,0,0,0,1]) the answer should be 1 instead of 7
