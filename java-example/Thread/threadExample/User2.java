package Thread0331;

public class User2 extends Thread{
    private Calculator calculator;

    public void setCalculater(Calculator calculator) {
        this.setName("U2");
        this.calculator = calculator;
    }

    public void run() {
        calculator.setMemory(50);
    }

}
