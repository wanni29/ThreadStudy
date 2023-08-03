# Thread
- 쓰레드(Thread)는 컴퓨터 프로그램의 실행 단위로, 하나의 프로세스 내에서 동작하는 여러 실행 흐름 중 하나

- 하나의 프로세스 안에서 여러 개의 쓰레드가 동시에 작업을 수행할 수 있습니다

```
✔쓰레드 주의 사항

1. 경쟁 상태(Race Condition): 여러 쓰레드가 동시에 공유 자원에 접근할 때, 데이터의 일관성을 유지하기 어려운 상황이 발생

2. 교착상태(Deadlock): 두 개 이상의 쓰레드가 서로가 소유한 자원을 기다리면서 무한정 대기하는 상태

3. 스레드 간 우선순위: 프로그래머는 쓰레드의 우선순위를 지정할 수 있지만, 이로 인해 어떤 쓰레드가 더 많이 실행되거나, 다른 쓰레드들이 무시될 수 있습니다.

```

```java

public class ThreadExample {
    public static void main(String[] args) {

        // 쓰레드 객체 생성
        Thread thread1 = new Thread(new PrintNumbers());
        Thread thread2 = new Thread(new PrintLetters());

        // 쓰레드 실행
        thread1.start();
        thread2.start();

        // 메인 쓰레드는 쓰레들이 모두 끝날 때까지 기다림
        // join()은 쓰레드(Thread) 관련 메서드로, 자바(Java)에서 사용됩니다. 
        // 이 메서드는 현재 실행 중인 쓰레드가 다른 쓰레드의 작업이 끝날 때까지 기다리도록 합니다. 
        // 즉, join() 메서드를 호출한 쓰레드는 
        // 대상 쓰레드가 작업을 완료할 때까지 블로킹(blocking) 상태가 됩니다
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
// Runnable 인터페이스를 구현하여 쓰레드를 생성한다.
// 각 쓰레드 클래스는 run() 메서드를 오버라이드하여 쓰레드가 실행될 동작을 정의
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



```