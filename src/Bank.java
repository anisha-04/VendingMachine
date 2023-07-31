public class Bank {
    private static final int MAX = 5; // the maximum possible number of accounts
    private String bankName;
    private Account [] accounts;
    private int count; // the actual number of accounts

    public Bank(String bankName) {
        this.bankName = bankName;
        this.count = 0;
        this.accounts = new Account[MAX];
    }

    public boolean openAccount(Customer accountOwner,
                               int accountNumber, int accountType, double balance)
    {
        if(MAX > count){
           Account account = new Account(accountNumber, accountType, balance, accountOwner);
           accounts[count] = account;
           count++;
           return true;
        }else{
          return false; 
        }
    }

    public boolean closeAccount(int accountNumber) {
      
    	int flag=0;
    	for (Account account : accounts) {
			
			if(account.getAccountNumber()==accountNumber)
			{
				account.close();
				flag=1;
			}
		}
    	if(flag==1)
    		return true;
    	else
    		return false;
    	
    	/*int i = 0;
      int flag=0;
      System.out.println(count);
      System.out.println(accounts.length);
      while(i<count)
      {
         if(accounts[i].getAccountNumber() == accountNumber){
        	
                    accounts[i].close();
                    i++;
                    flag=1;
                    break;
         }
      }
      if(flag==1)
      {
    	  flag=0;
    	  System.out.println("account found");
    	  return true;
    	  
      }
      else
      {
      System.out.println("return fasle");
      	return false;
      }*/
    	
    }

    
    
    
    public String toString() {
        String str ="";
         double balance = 0.0;
         
         int i = 0;
         while(i<count){
            str += accounts[i].toString() + "\n";
           balance += accounts[i].getBalance();
           i++;
         }
       
          return "Bank Name: " + bankName + "\n" 
               + "Number of Accounts: " + count + "\n"
               + str + "\n"
               + "Bank Total Balance: " + toDollars(balance) + "\n";
    }

    public boolean printAccountInfo(int accountNumber) {
      
    	int flag=0;
    	for (Account account : accounts) {
			if(account.getAccountNumber()==accountNumber)
			{
				System.out.println(account);
				flag=1;
			}
		}
    	if(flag==1)
    		return true;
    	else
    		return false;
    	
    	
    	
    	/*  int i = 0;
       while(i<count){
           if(accounts[i].getAccountNumber() == accountNumber){
                       System.out.println(accounts[i]);
                       return true;
                   }
       }
         return false;*/
    }

    private boolean isAccountNumberUsed(int accountNumber) {
    	int flag=0;
    	for (Account account : accounts) {
			if(account.getAccountNumber()==accountNumber)
			{
				flag=1;
			}
		}
    	if(flag==1)
    		return true;
    	else
    		return false;
    }
    
    
    public static String toDollars(double u) {
        return String.format("$%.2f", u);
    }

}
