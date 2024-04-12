//concept of Thread Safety, Runnable with Lambda, and Thread.join()
class IncrementTest {
    private int count = 0;

     // if i remove synchronized, then Thread Safety is violated
     synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

public class RunnableWithLambda {

    public static void main(String[] args) throws InterruptedException {
        IncrementTest incrementTest = new IncrementTest();
        Runnable t1 = () -> {
            for (int i = 0; i < 10000; i++) {
                incrementTest.increment();
            }
        };
        Runnable t2 = () -> {
            for (int i = 0; i < 10000; i++) {
                incrementTest.increment();
            }
        };

        Thread one = new Thread(t1);
        Thread two = new Thread(t2);

        one.start();
        two.start();
        Thread.sleep(100);

        one.join();
        two.join();

        System.out.println(incrementTest.getCount());
    }
}