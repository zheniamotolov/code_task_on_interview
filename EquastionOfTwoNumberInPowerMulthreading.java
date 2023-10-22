import java.math.BigInteger;

public class EquastionOfTwoNumberInPowerMulthreading {
    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = BigInteger.ZERO;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1,power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2,power2);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        result = thread1.getResult().add(thread2.getResult());
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ZERO;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {

            for (int i = 0; i <= power.intValue(); i++) {
                if (i == 0) {
                    result = BigInteger.ONE;
                    continue;
                }

                result = result.multiply(base);
            }
           /*
           Implement the calculation of result = base ^ power
           */
        }

        public BigInteger getResult() {
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(calculateResult(BigInteger.TWO, BigInteger.TEN, BigInteger.TWO, BigInteger.ZERO).intValue());

    }
}

