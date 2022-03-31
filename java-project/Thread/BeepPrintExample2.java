package Thread0331;

// Thread 하위 클래스로부터 생성(상속)
public class BeepPrintExample2 {
    public static void main(String[] args) {
        //BeepThread 객체 생성
        BeepThread bt = new BeepThread();
        Thread thread = bt;
        //작업 스레드 작업시작
        thread.start();

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try{ Thread.sleep(500); } catch(Exception e) { }
        }

    }
}
