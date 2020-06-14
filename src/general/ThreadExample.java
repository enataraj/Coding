package general;

public class ThreadExample {

    public static void main(String[] args) {
        new Thread(new ThreadTest()).start();

    }
}

class ThreadTest implements Runnable {
    public void run() {
        System.out.println("Ho ");
    }
}