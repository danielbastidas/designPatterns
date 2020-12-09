/** This scratch show what is the following capicua number given a number k */
class Scratch {
    public static void main(String[] args) {
        int k = 100525;
        int numberLength = String.valueOf(k).length();
        int digit = 0;
        int base =0;
        if (numberLength-1==0) {
            base=1;
        } else if (numberLength-1==1) {
            base=11;
        } else if (numberLength-1>1) {
            digit = k/(int)Math.pow(10, numberLength-1);
            base=digit*(int)Math.pow(10, numberLength-1) + digit;
        }

        int sumFactor = 0;
        if (numberLength == 1) {
            sumFactor=1;
        } else {
            sumFactor = (int)Math.pow(10, numberLength-2);
            if (numberLength-2 == 0 || numberLength-2>1) {
                sumFactor+=10;
            }
        }

        int capicua = base;
        while (capicua < k+1) {
            capicua+=sumFactor;
        }

        System.out.printf("The next capicua value greater than %d is: %d",
                k, capicua);
    }
}