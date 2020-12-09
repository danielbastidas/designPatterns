import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) throws Exception {

        int[] h = new int[10];

        h[0] = 8979; h[1] = 4570; h[2] = 6436;
        h[3] = 5083; h[4] = 7780; h[5] = 3269;
        h[6] = 5400; h[7] = 7579; h[8] = 2324;
        h[9] = 2116;

        System.out.println(largestRectangle(h));
    }

    static long largestRectangle(int[] h) {

        long area = 0;
        int k =0;
        int min = h[0];
        Stack<Integer> stack = new Stack<>();

        stack.push(h[0]);
        for (int i = 1; i < h.length; i++ ) {
            if (h[i] > stack.peek()) {
                stack.push(h[i]);
                area = Math.max(area, (i+1)*min);
            } else {
                boolean flag = false;
                int value = 0;
                while(!stack.isEmpty()) {
                    value = stack.pop();
                    if (value < h[i]) {
                        min = value;
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    area = Math.max(area, (i+1)*min);
                    stack.push(min);
                } else {
                    area = Math.max(area, (i+1)*h[i]);
                    stack.push(h[i]);
                    min = h[i];
                }

            }
        }



        //IntStream.of(h).forEach( i -> stack.push(i));
//        for (int i = 0; i < h.length; i++ ) {
//            stack.push(h[i]);
//        }
//
//        while (!stack.isEmpty()) {
//            k++;
//            min = Math.min(stack.pop(), min);
//            area = Math.max(area, k*min);
//        }

        return area;
    }
}