class Scratch {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,2,2,2,2,2};
        int[] B = new int[]{2,2,3,3,4,5,6};
        int[] C = new int[]{6,2,2};

        Scratch scratch = new Scratch();
        System.out.println(scratch.solution(A, B, C));
    }

    public int solution(int[] A, int[] B, int[] C) {

        int minValue = 1;
        int maxvalue = C.length;
        int possibleValue = -1;
        boolean valid = true;

        while (minValue <= maxvalue && valid) {
            final int mid = (minValue+maxvalue)/2;

            final boolean ok = checkNailed(mid, A, B, C);

            if (ok) {
                possibleValue = mid;
                maxvalue = mid -1;
            } else if (mid >= maxvalue && possibleValue == -1) {
                possibleValue = -1;
                valid = false;
            } else {
                minValue = mid+1;
            }
        }

        return possibleValue;

    }

//    public boolean checkNailed(int possibleValue, int[] A, int[] B, int[] C) {
//
//        int plank = 0;
//        int nail = 0;
//        boolean valid = true;
//
//        while (nail <= possibleValue && plank < A.length && valid) {
//
//            if (C[nail]>= A[plank] && C[nail] <= B[plank]) {
//                plank++;
//            } else {
//                nail++;
//                if (nail > possibleValue) {
//                    valid = false;
//                }
//            }
//
//        }
//
//        return valid;
//    }

    public boolean checkNailed(int possibleValue, int[] A, int[] B, int[] C) {

        int plank = A.length;
        int nail = 0;
        boolean valid = true;
        boolean[] checked = new boolean[A.length];

        while (nail < possibleValue) {
            for (int i=0;i<A.length && plank>0;i++) {
                if ( !checked[i] && C[nail]>= A[i] && C[nail] <= B[i]) {
                    plank--;
                    checked[i] = true;
                }
            }
            nail++;
        }

        return plank==0;
    }
}