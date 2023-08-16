import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadStudy05 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<String>> tasks = Arrays.asList(

                () -> "Task 1 result",
                () -> "Task 2 result",
                () -> "Task 3 result"

        );

        try {
            List<Future<String>> futures = executorService.invokeAll(tasks);

            for (Future<String> future : futures) {
                System.out.println("Result : " + future.get());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

}
