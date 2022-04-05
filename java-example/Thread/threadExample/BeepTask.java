package Thread0331;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
    public BeepTask() {
    }

    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i = 0; i < 5; ++i) {
            toolkit.beep();

            try {
                Thread.sleep(500L);
            } catch (Exception var4) {
            }
        }

    }
}
