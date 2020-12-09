import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        List<Integer> p = new ArrayList(){{
            add(2);
            add(5);
            add(3);
        }};

        List<Integer> q = new ArrayList(){{
            add(1);
            add(5);
        }};
        int k=3;

        System.out.println(Arrays.deepToString(kthPerson(k, p, q).toArray()));
    }

    public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {

        List<Integer> output = new ArrayList();
        int seatsFilled = 0;
        int index = 0;
        int kIndex = 0;

        for (Integer qTime: q) {

            seatsFilled = 0;
            index = 0;
            kIndex = 0;
            while (seatsFilled < k && index < p.size()) {

                if (p.get(index) >= qTime) {
                    seatsFilled++;
                    kIndex = index+1;
                }
                index++;

            }

            output.add( (seatsFilled == k )? kIndex : 0 );

        }

        return output;

    }

}