public class ThreadExample {
    public static void main(String[] args) {

        // 쓰레드 객체 생성
        Thread thread1 = new Thread(new PrintNumbers());
        Thread thread2 = new Thread(new PrintLetters());

        // 쓰레드 실행
        thread1.start();
        thread2.start();

        // 메인 쓰레드는 쓰레들이 모두 끝날 때까지 기다림
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread : All threads are done!");

    }
}

// 숫자를 출력하는 쓰레드 클래스
class PrintNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 1 - Number : " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

// 문자를 출력하는 쓰레드 클래스
class PrintLetters implements Runnable {
    @Override
    public void run() {
        for (char letter = 'A'; letter <= 'E'; letter++) {
            System.out.println("Thread 2 - Letter : " + letter);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
