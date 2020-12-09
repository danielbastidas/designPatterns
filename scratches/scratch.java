import java.util.HashMap;
import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        String s = "mnonopoo";
        System.out.println(substrCount(s.length(), s));
    }

    static long substrCount(int n, String s) {

        Map<String, Integer> freqs = new HashMap<>();
        long count = 0;
        String c = null;
        for (int i = 0 ;i < n;i++) {
            c = String.valueOf(s.charAt(i));
            freqs.put(c, freqs.get(c) != null?
                    freqs.get(c)+1:1 );
        }

        for (int i =0; i<n;i++) {

            if (i>0) {
                c = String.valueOf(s.charAt(i-1));
                freqs.put(c,
                        freqs.get(c)-1);
                if (freqs.get(c) == 0) {
                    freqs.remove(c);
                }
            }

            Map<String, Integer> freqsCopy = new HashMap<>(freqs);

            for (int j =n;j>i;j--) {
                if (j < n) {
                    c = String.valueOf(s.charAt(j));
                    freqsCopy.put(c,
                            freqsCopy.get(c)-1);
                    if (freqsCopy.get(c) == 0) {
                        freqsCopy.remove(c);
                    }

                }
                if (isSpecial(s.substring(i, j), freqsCopy)) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean isSpecial(String s, Map<String, Integer> freqs) {
        boolean isSpecial = false;

        if (freqs.size() == 1) {
            isSpecial = true;
        } else if (freqs.size()>=3) {
            isSpecial = false;
        } else { // freqs.size ==2
            int min = Integer.MAX_VALUE;
            String minKey = null;
            for (Map.Entry<String, Integer> entry: freqs.entrySet()) {
                if ( freqs.get(entry.getKey()) < min ) {
                    min = freqs.get(entry.getKey());
                    minKey = entry.getKey();
                }
            }

            Integer[] temp = freqs.values().toArray(new Integer[0]);
            isSpecial =
                    s.indexOf(minKey) == s.length()/2 && temp[0] != temp[1];
        }

        return isSpecial;
    }
}