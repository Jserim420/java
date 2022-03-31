package Thread0331;

//Thread 클래스로부터 스레드 직접 생성
public class BeepPrintExample {
    public static void main(String[] args) {
        // 인터페이스로 BeepTask 객체 구현
        Runnable BeepTask = new BeepTask();
        // 작업 스레드 불러오기
        Thread thread = new Thread(BeepTask);
        thread.start();

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500);
            } catch(Exception e ) { }
        }
    }
}
