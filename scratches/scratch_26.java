class Scratch {
    public static void main(String[] args) {

        Scratch scratch = new Scratch();
//        int[] A = new int[]{0,0,0,1,1,0,1,0,0,0,0};
        int[] A = new int[]{1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(scratch.solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 11
        int result = jump(0,1,-1,0,Integer.MAX_VALUE,A);
        return result == Integer.MAX_VALUE? -1:result;
    }

    public int jump(int a, int b, int pos, int jumps, int min, int[] A) {

        if (pos+a>=A.length) {
            return (jumps>0)?jumps+1:min;
        }

        for (int i = a;i+pos<=A.length;i=b) {

            if (pos+a>=0 && pos+a<=A.length && A[pos+a]==1){
                min = Math.min(min, jump(1,1,pos+a, jumps+1, min, A));
            }
            int temp = a;
            a = b;
            b = temp+b;

        }

        return min;

    }

//    public int solution(int[] A) {
//        return jump(-1, 0, 0, 1, Integer.MAX_VALUE, A);
//    }
//
//    public int jump(int position, int jumps, int fibA, int fibB,
//                    int min, int[] A) {
//
//        if (position >= A.length) {
//            return jumps;
//        }
//
//        if (position == -1 || A[position]!=0) {
//            min = Math.min(min,
//                    jump(position + fibA, jumps++, fibB, fibB + fibA, min, A) +
//                    jump(position + fibB, jumps++, fibB, fibB + fibA, min, A));
//        }
//
//        return min;
//    }
}