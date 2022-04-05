package threadWait;

public class DataBox {
    private String data;

    public synchronized String getData() {
        if(this.data==null) {
            try{
                wait();
            } catch(InterruptedException e) {}
        }
        String returnString = data;
        System.out.println("ConsumerThread가 읽은 데이터 : " + returnString);
        data = null;
        notify();
        return returnString;
    }

    public synchronized void setData(String data) {
        if(this.data!=null) {
            try{
                wait();
            } catch(InterruptedException e) { }
        }
        this.data = data;
        System.out.println("ProducerThread가 생성한 데이터 : " + data);
        notify();
    }

}
