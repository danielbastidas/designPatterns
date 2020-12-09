
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Scratch {
    public static void main(String[] args) {
        List<Integer> stockData = new ArrayList(){{
            add(5);
            add(6);
            add(8);
            add(4);
            add(9);
            add(10);
            add(8);
            add(3);
            add(6);
            add(4);
        }};

        List<Integer> queries = new ArrayList(){{
           add(3);
           add(1);
           add(8);
        }};

//        IntStream.range(0, queries.size()).mapToObj( index-> index).
//                parallel().forEach(index -> System.out.println(index+":"+queries.get(index)));

        System.out.println(Arrays.deepToString( predictAnswer(stockData,
                queries).toArray() ));
    }

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {

        List<Integer> result =
                new ArrayList<Integer>(Collections.nCopies(queries.size(),
                        -1));

        List<Integer> valueForDay = new ArrayList(stockData.size());

        for (int i=0;i < stockData.size();i++) {
            int day = i;
            int prevIndex=0;
            int postIndex=0;
            boolean breakFlagPrev = false;
            boolean breakFlagPost = false;
            prevIndex=day-1;
            postIndex=day+1;
            while (!breakFlagPrev && !breakFlagPost && (prevIndex>=0 || postIndex<=stockData.size())) {

                if ( prevIndex>=0 && stockData.get(prevIndex)<stockData.get(i) ) {
                    breakFlagPrev = true;
                    valueForDay.add(prevIndex);
                }
                if ( !breakFlagPrev && postIndex<stockData.size() && stockData.get(postIndex)<stockData.get(i) ) {
                    breakFlagPost = true;
                    valueForDay.add(postIndex);
                }
                prevIndex--;
                postIndex++;
            }

            if (!breakFlagPrev && !breakFlagPost ) {
                valueForDay.add(-1);
            }
        }

        System.out.println(Arrays.deepToString(valueForDay.toArray()));
        return result;

    }

}