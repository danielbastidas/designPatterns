import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

class Scratch {
    static Map<Integer, Integer> cache = new Hashtable<>();
    public static void main(String[] args) {
        int n = 3;
        System.out.println(stepPerms(n));
    }

    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        cache = new Hashtable<>();
        return climb(0,n);

    }

//    public static int climb(int step, int n) {
//        if (step >= n) {
//            return step == n? 1:0;
//        }
//
//        return climb(step+1, n) + climb(step + 2, n) + climb(step + 3, n);
//    }

//    public static int climb(int step) {
//        if (step == 1) {
//            return 1;
//        }
//        if (step == 2) {
//            return 2;
//        }
//        if (step == 3) {
//            return 4;
//        }
//
//        if (!cache.containsKey(step)) {
//            int count = climb(step-1) + climb(step-2)+climb(step-3);
//            cache.put(step, count);
//        }
//
//        return cache.get(step);
//    }

    public static int climb(int step, int n) {
        if (step >= n) {
            return step == n? 1:0;
        }

        if (!cache.containsKey(step)) {
            int count = climb(step+1, n) + climb(step + 2, n) + climb(step + 3, n);
            cache.put(step, count);
        }
        return cache.get(step);
    }
}