package Thread0331;

import java.awt.*;

public class BeepTask implements Runnable{
    public void run() {
        //Toolkit 객체 얻기
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
