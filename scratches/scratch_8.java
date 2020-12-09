import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] arr = new int[7];
//        1 3 5 2 4 6 7
        arr[0] =1;arr[1] =3; arr[2] =5; arr[3] =2;arr[4] =4; arr[5] =6; arr[6] =7;
        int[] sortedArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(sortedArr);
        int swaps = 0;
        int i = 0;
        int moves = 0;
        int temp = 0;

        do {
            if (arr[i] != sortedArr[i]) {
                moves = (arr[i] - sortedArr[i])+i;
                temp = arr[moves];
                arr[moves] = arr[i];
                arr[i] = temp;
                swaps++;
            } else {
                i++;
            }
        }
        while( i < arr.length /*|| arr[i] != sortedArr[i]*/ );

        System.out.println(swaps);


    }
}