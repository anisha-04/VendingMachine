public class Account {
    private int accountNumber;
    private int accountType;
    private double balance;
    private Customer accountOwner;
    private boolean closed;

    public Account(int accountNumber, int accountType, double balance, Customer accountOwner) {
        this.accountNumber = accountNumber;
       this.accountType = accountType;
       this.balance = balance;
       this.accountOwner = accountOwner;
    }

    public void close() {
        this.closed = true;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getAccountOwner() {
        return accountOwner;
    }

    public String getAccountType() {
        if (accountType == 1) {
                return "Checking";
            } else if (accountType == 2) {
                return "Savings";
            } else {
                return "";
            }
    }

    public String toString() {
         return "Account Number: " + getAccountNumber() + " " + getAccountType()  + " Balance: $" + 
         String.format("%.2f", getBalance()) + " " + accountOwner.toString();        
    }

}
