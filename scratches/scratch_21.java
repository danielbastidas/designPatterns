import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        int[] A = new int[3];
        A[0] = -1;
        A[1] = -2;
        A[2] = -3;

        System.out.println(scratch.solution(A));
    }

    public int solution(int[] A) {
        int max = -1*1000000001;
        int[] dp = new int[A.length];
        dp[0] = A[0];

        for (int i=1; i< A.length;i++) {
            max = -1*1000000001;
            int j =1;
            while (j<=6) {
                if (i-j>=0) {
                    max = Math.max(max, A[i]+dp[i-j]);
                }
                j++;
            }
            dp[i] = max;
        }

        return max;
    }

//    public int solution2(int[] A) {
//        int max = -1*1000000001;
//        int[] dp = new int[A.length];
//        dp[0] = A[0];
//
//        for (int i=1; i< A.length;i++) {
//            max = -1*1000000001;
//            if (i-1 >=0) {
//                max = Math.max(max, A[i]+dp[i-1]);
//            }
//            if (i-2 >=0) {
//                max = Math.max(max, A[i]+dp[i-2]);
//            }
//            if (i-3 >=0) {
//                max = Math.max(max, A[i]+dp[i-3]);
//            }
//            if (i-4 >=0) {
//                max = Math.max(max, A[i]+dp[i-4]);
//            }
//            if (i-5 >=0) {
//                max = Math.max(max, A[i]+dp[i-5]);
//            }
//            if (i-6 >=0) {
//                max = Math.max(max, A[i]+dp[i-6]);
//            }
//            dp[i] = max;
//        }
//
//        return max;
//    }

//    public int solution(int[] A) {
//        // write your code in Java SE 8
//        int max = -1*1000000001;
//        for (int i =1;i<A.length;i++) {
//
//            if (i==A.length-1) {
//                if (i<=6) {
//                    max = Math.max(max+A[i], A[0]+A[i]);
//                } else {
//                    max = max+A[i];
//                }
//            } else if (i<=6) {
//                max = Math.max(max,Math.max(A[0]+A[i], max+A[i]));
//            } else {
//                max = Math.max(max, max+A[i]);
//            }
//
//        }
//        return max;
//    }

//    public int solution(int[] A) {
//        // write your code in Java SE 8
//        List<Integer> l1 = new ArrayList(){{add(A[0]);}};
//        List<Integer> l2 = Arrays.stream(A).boxed().collect(Collectors.toList());
//        l2.remove(0);
//        int max = combinations(l1, l2, 0, A.length, -Integer.MAX_VALUE);
//        return max;
//    }

    public int combinations(List<Integer> l1,List<Integer> l2, int index, int n, int max) {

        if (index == n-1) {
            max = Math.max(max, calculateSum(l1));
            return max;
        }

        for (int i=0;i<l2.size();i++) {


            List<Integer> newl1 = new ArrayList<>(l1);
            newl1.add(l2.get(i));
            List<Integer> newl2 = new ArrayList<>(l2.subList(i+1, l2.size()));

            max = combinations(newl1, newl2, index+(i+1),n , max);

        }

        return max;

    }

    public int calculateSum(List<Integer> list)  {
        return list.stream().reduce(0, (Integer a, Integer b) -> a+b);
    }

}