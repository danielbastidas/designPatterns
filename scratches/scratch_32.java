import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Scratch {
    public static void main(String[] args) {
        
    }

    public int solution(int[] A) {

        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i =0;i<A.length;i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i])+1);
            }
        }

        boolean flag = true;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext() && flag) {
            answer = iterator.next();
            if (map.get(answer) % 2 != 0) {
                flag = false;
            }
        }

        return answer;

    }
}