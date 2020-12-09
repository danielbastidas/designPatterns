import java.util.HashMap;
import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        int[] array = new int[6];
        array[0] = 1;
        array[1] = 3;
        array[2] = 6;
        array[3] = 4;
        array[4] = 1;
        array[5] = 2;
        Scratch scratch = new Scratch();
        System.out.println(scratch.solution(array));
    }

    public int solution(int[] A) {
        int number = 1;
        Map<Integer, Boolean> lookUpTable = new HashMap<>();

        for (int i = 0;i< A.length;i++) {
            lookUpTable.putIfAbsent(A[i], true);
        }

        while (lookUpTable.containsKey(number)) {
            number++;
        }

        return number;
    }
}