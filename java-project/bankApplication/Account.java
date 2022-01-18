public class Account {
    private String accountNo;
    private String accountOwner;
    private int balance;

    public Account(String accountNo, String accountOwner, int balance){
        this.accountNo=accountNo;
        this.accountOwner=accountOwner;
        this.balance=balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
