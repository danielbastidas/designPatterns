import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};

        A =
            Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

//        Arrays.sort(A, Arrays.);

        System.out.println(Arrays.deepToString( Arrays.stream(A).boxed().collect(Collectors.toList()).toArray() ));
    }

    public int solution(int[] A) {
        // write your code in Java SE 11

        long N = A.length;
        long sum = Arrays.stream(A).reduce(0, (a, b) -> a+b);
        long expectedValue = ((N+1)*(N+2))/2L;

        return (int)(expectedValue - sum);

    }
}