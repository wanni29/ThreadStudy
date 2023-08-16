import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadStudy02 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable thread1 = () -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("Thread1 : " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable thread2 = () -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("Thread2 : " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        executor.submit(thread1);
        executor.submit(thread2);

        executor.shutdown();

    }
}
