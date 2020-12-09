import java.math.BigInteger;

class Scratch {
    public static void main(String[] args) {

        for (int i=0; i< 100000;i++) {
            BigInteger primeTest = BigInteger.valueOf(i);
            if (primeTest.isProbablePrime(1)) {
                System.out.println(i+" ");
            }
        }
    }
}