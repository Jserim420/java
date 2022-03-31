package Thread0331;

public class User1 extends Thread{
    private Calculator calculator;

    public void setCalculater(Calculator calculator) {
        this.setName("U1");
        this.calculator = calculator;
    }

    public void run() {
        calculator.setMemory(100);
    }
}
