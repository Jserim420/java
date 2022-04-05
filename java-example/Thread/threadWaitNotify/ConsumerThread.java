package threadWait;

public class ConsumerThread extends Thread{
    DataBox dataBox;

    public ConsumerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for(int i=0; i<3; i++) {
            String data = dataBox.getData();
        }
    }
}
