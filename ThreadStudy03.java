import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadStudy03 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2); // 스레드를 2개만 쓰겠다.

        executorService.execute(() -> {
            System.out.println("Task 1 executed.");
        });

        executorService.execute(() -> {
            System.out.println("Task 2 executed.");
        });

        executorService.shutdown();

    }

}
