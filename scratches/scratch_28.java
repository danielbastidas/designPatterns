import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        
    }

    public int solution(int[] A) {
        // write your code in Java SE 11

        List<Integer> possitives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int max = -Integer.MAX_VALUE;

        for (int i=0; i<A.length;i++) {
            if (A[i] >= 0) {
                possitives.add(A[i]);
            } else {
                negatives.add(A[i]);
            }
        }

        Collections.sort(possitives);
        Collections.sort(negatives);

        List<Integer> merged = new ArrayList<>();
        possitives.addAll(negatives);
        merged.addAll(possitives);

        for (int i=0;i<=merged.size()-3;i++) {
            max = Math.max(max, merged.get(i)*merged.get(i+1)*merged.get(i+2));
        }

        return max;

    }
}