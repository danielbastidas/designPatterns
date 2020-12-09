//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Scratch {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-dd-MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        Date d1 = sdf1.parse("2020-29-10");
        System.out.println(d1);
        Date d2 = sdf2.parse("2020-10-28");
        System.out.println(d2);

        boolean after = d1.after(d2);
        System.out.println(after);

    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Long leftCount =0L, rightCount =0L;
        Integer leftFreq = 0, rightFreq =0;

        Map<Long,Long> freqs = new HashMap<>();
        long count = 0L;

        for (Long value: arr) {
            if (freqs.get(value) != null) {
                freqs.put(value, freqs.get(value)+1);
            } else {
                freqs.put(value, 1L);
            }
        }

        System.out.println(freqs);

        for (int i=0;i<arr.size();i++) {
            if (i-1 < 0) {
                continue;
            }
            if (i+1 >= arr.size()) {
                continue;
            }
            leftCount = freqs.get(arr.get(i)/r);
            rightCount = freqs.get(arr.get(i)*r)-1;

            if (leftCount != null && rightCount != null) {
                count+=leftCount*rightCount;
            }

        }

        return count;

    }

//    public static int getTransactions(int userId, int locationId,
//                                      int netStart, int netEnd) throws Exception {
//
//        URL url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId="+userId);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//
//        // Convert to a JSON object to print data
//        JsonParser jp = new JsonParser(); //from gson
//        JsonElement root = jp.parse(new InputStreamReader((InputStream) conn.getContent()));
//        JsonObject rootObj = root.getAsJsonObject();
//
//        int totalPages = rootObj.get("total_pages").getAsInt();
//
//        JsonArray data = rootObj.getAsJsonArray("data");
//        for (JsonElement element:data) {
//            System.out.println("element="+element.getAsJsonObject());
//        }
//        System.out.println(rootObj);
//
//        return 0;
//
//    }
}