import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Scratch {
    public static void main(String[] args) throws Exception {

//        List<List<Integer>> queries = new ArrayList<>();

        //case 0
//        queries.add(0, new ArrayList(){{add(1); add(5); }});
//        queries.add(1, new ArrayList(){{add(1); add(6); }});
//        queries.add(2, new ArrayList(){{add(3); add(2); }});
//        queries.add(3, new ArrayList(){{add(1); add(10); }});
//        queries.add(4, new ArrayList(){{add(1); add(10); }});
//        queries.add(5, new ArrayList(){{add(1); add(6); }});
//        queries.add(6, new ArrayList(){{add(2); add(5); }});
//        queries.add(7, new ArrayList(){{add(3); add(2); }});

        //case 1
//        queries.add(0, new ArrayList(){{add(3); add(4); }});
//        queries.add(1, new ArrayList(){{add(2); add(1003); }});
//        queries.add(2, new ArrayList(){{add(1); add(16); }});
//        queries.add(3, new ArrayList(){{add(3); add(1); }});

        // my case 1
//        queries.add(0, new ArrayList(){{add(1); add(6); }});
//        queries.add(1, new ArrayList(){{add(1); add(6); }});
//        queries.add(2, new ArrayList(){{add(1); add(6); }});
//        queries.add(3, new ArrayList(){{add(2); add(6); }});
//        queries.add(4, new ArrayList(){{add(2); add(6); }});
//        queries.add(5, new ArrayList(){{add(2); add(6); }});
//        queries.add(6, new ArrayList(){{add(2); add(6); }});
//        queries.add(7, new ArrayList(){{add(3); add(1); }});

//        System.out.println(freqQuery(queries));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/home/danielbastidas/.config/JetBrains/IdeaIC2020" +
                        ".2/scratches/output"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();

    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<>();
        int operation = 0, value = 0, index = 0, temp = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> freqs = new HashMap<>();
        List<Integer> adjustedValues = null;

        for (List<Integer> query : queries) {
            operation = query.get(0);
            value = query.get(1);
            switch (operation) {
                case 1:
                    map.put(value, map.get(value) != null ? map.get(value) + 1
                            : 1);
                    if (freqs.get(map.get(value)) != null) {
                        index =
                                Collections.binarySearch(freqs.get(map.get(value)), value);
                        List<Integer> values = freqs.get(map.get(value));
                        values.add(index < 0 ? -index - 1 : index, value);
                    } else {
                        List<Integer> values = new ArrayList<>();
                        values.add(value);
                        freqs.put(map.get(value), values);
                    }

                    if ( map.get(value) - 1 > 0 ) {
                        adjustedValues = freqs.get(map.get(value) - 1);
                        index = Collections.binarySearch(adjustedValues, value);
                        // it is safe to assume that exists
                        if (index >= 0) {
                            adjustedValues.remove(index);
                        }
                    }

                    break;
                case 2:
//                    boolean flag = false;
                    if (map.get(value) != null && map.get(value) > 0) {
                        List<Integer> values = freqs.get(map.get(value));
                        index = Collections.binarySearch(values,
                                value);

                        temp = map.get(value);
                        if (index >= 0) {
                            values.remove(index);
                            temp = map.get(value) - 1;
                            map.put(value, map.get(value) - 1);
                        }

//                        if ( flag && map.get(value)> 0 || !flag && map.get(value)> 0) {
                        if (temp > 0) {
                            adjustedValues =
                                    freqs.get(temp);
                            index = Collections.binarySearch(adjustedValues,
                                    value /*- 1*/);
                            if (index < 0) {
                                adjustedValues.add(-index - 1, value);
                            } else {
                                System.out.println("!!!!!!!!!!!!!Paso");
                            }
//                            adjustedValues.add( index < 0? -index - 1:, value);

                        }
                    }
                    break;
                case 3:
                    output.add(freqs.get(value) != null && freqs.get(value).size() >0
                            ? 1 : 0);
                    break;
            }

        }
        return output;
    }

}