import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        String s = "abcdefghhgfedecba";
        HashMap<Character, Integer> freqs = new HashMap<>();
        for (int i=0; i< s.length();i++) {
            Character c = s.charAt(i);
            freqs.put(c, freqs.get(c) != null ?
                    freqs.get(c)+1 : 1 );
        }

        int mustBe = (int)Math.ceil(s.length() / (double)freqs.size());
        System.out.println(Math.round(17/(double)8));
//        System.out.println(Math.ceil((double)(17+8-1)/8));
        int countDiff = 0;
        Iterator<Integer> iter = freqs.values().iterator();

        while (iter.hasNext() /*&& countDiff <= 1*/ ) {
            int value = iter.next();
            if (value != mustBe) {
                countDiff+=Math.abs(value - mustBe);
            }
            // else {
            //     countDiff--;
            // }
        }

        System.out.println("strawberry".substring(11,2));
        List list = new ArrayList();
        list.add(2);
        list.add("hello");

        System.out.println(countDiff<2?"YES":"NO");


        try {
            System.out.println("test");
        } catch (Exception e){

        } catch (ArithmeticException e2) {
            
        }

    }
}