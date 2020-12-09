import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Scratch {
    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] =25;
        array[1] =1165;
        array[2] =18;
        System.out.println(solution(array));

    }

    public static class FactorNumber implements Comparator<FactorNumber> {
        int number;
        int amount;

        public FactorNumber(int number, int amount) {
            this.number = number;
            this.amount = amount;
        }

        @Override
        public int compare(FactorNumber o1, FactorNumber o2) {
            return Integer.compare(o1.number, o2.number);
        }
    }

    static int solution(int[] input_arr) {

        List<HashMap<Integer, FactorNumber>> leastCommonMultiples =
                new ArrayList<>();
        int leastCommonMultiple = 1;
        int factor = 0;
        int value =0;

        for (int i = 0; i < input_arr.length;i++) {

            factor = 2;
            HashMap<Integer, FactorNumber> map = new HashMap<>();
            value = input_arr[i];
            do {

                if (value%factor == 0) {

                    FactorNumber factorNumber = new FactorNumber(factor,1);

                    if (map.containsKey(factor)) {
                        factorNumber = map.get(factor);
                        factorNumber.amount++;
                    } else {
                        map.put(factor, factorNumber);
                    }
                    value /=factor;
                } else {
                    factor++;
                }
            } while(value >1);
            leastCommonMultiples.add(map);
        }

        HashMap<Integer, FactorNumber> primeFactors = new HashMap<>();
        for (int i = 0; i < leastCommonMultiples.size();i++){
            HashMap<Integer, FactorNumber> map = leastCommonMultiples.get(i);
            for (Map.Entry<Integer, FactorNumber> entry: map.entrySet()) {

                if (primeFactors.containsKey(entry.getKey())) {
                    if (primeFactors.get(entry.getKey()).amount < map.get(entry.getKey()).amount) {
                        primeFactors.put(entry.getKey(),
                                map.get(entry.getKey()));
                    }
                } else {
                    primeFactors.put(entry.getKey(),
                            map.get(entry.getKey()));
                }

            }
        }

        for (FactorNumber val: primeFactors.values()) {
            leastCommonMultiple*=Math.pow(val.number, val.amount);
        }

        return leastCommonMultiple;
    }
}