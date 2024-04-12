class RunnableThreadOne implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class RunnableThreadTwo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class RunnableExample {

    public static void main(String[] args) {
        Runnable t1 = new RunnableThreadOne();
        Runnable t2 = new RunnableThreadTwo();

        Thread one = new Thread(t1);
        Thread two = new Thread(t2);

        one.start();
        two.start();
    }
}
