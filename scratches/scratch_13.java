import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Scratch {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int[] expenditure = new int[9];
//        int d = 5;
//
//        expenditure[0]=2;
//        expenditure[1]=3;
//        expenditure[2]=4;
//        expenditure[3]=2;
//        expenditure[4]=3;
//        expenditure[5]=6;
//        expenditure[6]=8;
//        expenditure[7]=4;
//        expenditure[8]=5;
//
//        System.out.println(activityNotifications(expenditure, d));

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        System.out.println(result);

        scanner.close();


    }

    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        int index =0;
        float median = 0;
        List<Integer> trailingDays = new ArrayList<>(d);
        HashMap<Integer, Float> medians = new HashMap<>();

        for (int i = 0; i< expenditure.length;i++) {

            index = Collections.binarySearch(trailingDays, expenditure[i]);
            if (trailingDays.size()==0) {
                trailingDays.add(expenditure[i]);
            } else {
                trailingDays.add( index < 0? -index-1: index,
                        expenditure[i] );
            }

            if (i>=d) {
                index = Collections.binarySearch(trailingDays,
                        expenditure[i-d]);
                trailingDays.remove(index);
            }

            if (i+1 >= d) {
                if (trailingDays.size()%2 == 0) {
                    median =
                            (trailingDays.get(trailingDays.size()/2)+trailingDays.get((trailingDays.size()/2)-1))/2f;
                } else {
                    median = trailingDays.get(trailingDays.size()/2);
                }

                medians.put(i+1, median);
            }

        }

        for (int  i = d; i < expenditure.length;i++) {

            if ( expenditure[i] >= medians.get(i)*2) {
                notifications++;
            }

        }

        return notifications;
    }
}