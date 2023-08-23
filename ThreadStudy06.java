
interface Callback1 {
    void complete(String data);
}

class Download {

    void fetch(Callback1 callback) {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                callback.complete("apple");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

public class ThreadStudy06 {
    public static void main(String[] args) throws Exception {
        Download d = new Download();
        d.fetch(data -> {
            System.out.println("다운받은 데이터로 그림을 그립니다. : " + data);
        });

    }
}

    
