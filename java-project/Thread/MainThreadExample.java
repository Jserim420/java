package Thread0331;


public class MainThreadExample {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        User1 user1 = new User1();
        user1.setCalculater(calculator);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculater(calculator);
        user2.start();
    }
}
