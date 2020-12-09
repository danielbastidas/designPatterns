import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Scratch {
    Map<Integer, Integer> lookUpTable = null;

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        int[] array = new int[4];
        array[0] = 1;
        array[1] = 6;
        array[2] = 11;
        array[3] = 5;

        System.out.println(Integer.MAX_VALUE);

        int[] a = new int[]{1,2,3};
        System.out.println(Arrays.deepToString(Arrays.stream(a).boxed().collect(Collectors.toList()).toArray()));

        scratch.lookUpTable = new HashMap<>();

        long t1 = System.currentTimeMillis();
        System.out.println(scratch.getCombinations(new ArrayList<>(),
                Arrays.stream(array).boxed().collect(Collectors.toList()),
                Integer.MAX_VALUE));
        System.out.println("Time:"+(System.currentTimeMillis()-t1));

//        scratch.getCombinations2(new ArrayList<>(),
//                Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    public int getCombinations(List<Integer> list1, List<Integer> list2, int min) {

//        List<Integer> l12 = new ArrayList<>(list1);
//        Collections.sort(l12);
//        Integer hash1 = Arrays.deepToString(l12.toArray()).hashCode();
//
//        List<Integer> l22 = new ArrayList<>(list2);
//        Collections.sort(l22);
//        Integer hash2 = Arrays.deepToString(l22.toArray()).hashCode();
//
//        if (lookUpTable.containsKey(hash1) && lookUpTable.containsKey(hash2)) {
//            return Math.min(min,
//                    Math.abs(lookUpTable.get(hash1) - lookUpTable.get(hash2)));
//        }

        if (list2.size() == 1) {
            return Math.min(min, Math.abs(getSum(list1) - getSum(list2)));
        }
        for (int i = 0; i < list2.size() && list2.size() > 1; i++) {

            List<Integer> newL2 = new ArrayList<>(list2);
            List<Integer> newL1 = new ArrayList<>(list1);
            newL1.add(newL2.remove(i));

            System.out.println("Try it combination");
            System.out.println(Arrays.deepToString(newL1.toArray()));
            System.out.println(Arrays.deepToString(newL2.toArray()));

            min = Math.min(min,
                    Math.abs(getSum(newL1) - getSum(newL2)));

            min = getCombinations(newL1, newL2,
                    min);

        }

        return min;

    }

    public void getCombinations2(List<Integer> list1, List<Integer> list2) {

        for (int i = 0; i < list2.size(); i++) {
//            list1.add(list2.get(i));

            List<Integer> newL1 = new ArrayList<>(list1);
            newL1.add(list2.get(i));
            System.out.println(Arrays.deepToString(newL1.toArray()));
            getCombinations2(newL1, list2.subList(i + 1,
                    list2.size()));
        }
    }

    public int getSum(List<Integer> list) {
        return list.stream().reduce(0,
                (integer, integer2) -> integer + integer2);
    }

    class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    class Checker implements Comparator<Player> {
        // complete this method
        public int compare(Player a, Player b) {
            if (a.score != b.score) {
                return Integer.compare(a.score, b.score);
            } else {
                return a.name.compareTo(b.name);
            }
        }
    }
}