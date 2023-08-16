import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadStudy04 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return 42;
        });

        executorService.shutdown();

        try {
            int result = future.get();
            System.out.println("Result : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
