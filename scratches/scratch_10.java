import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {

        int[] array = new int[7];
        array[0]=1;
        array[1]=2;
        array[2]=3;
        array[3]=4;
        array[4]=5;
        array[5]=6;
        array[6]=7;

        System.out.println(Arrays.deepToString(Arrays.asList(  rotLeft(array,
                4)).toArray() ));
    }

    static int[] rotLeft(int[] a, int d) {

        int[] rotLeftArray = Arrays.copyOf(a, a.length);
        int leftPosition = 0;

        for (int i=0;i < a.length;i++) {
            leftPosition = i-d;
            if (leftPosition < 0) {
                rotLeftArray[a.length - Math.abs(leftPosition)]=a[i];
            } else {
                rotLeftArray[leftPosition]=a[i];
            }
        }

        return rotLeftArray;

    }

}