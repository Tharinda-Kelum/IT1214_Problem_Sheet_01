class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	BankAccount(int accountNumber,String accountHolder,double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	int getAccountNumber(){
		return accountNumber;
	}
	
	String getAccountHolder(){
		return accountHolder;
	}
	
	double getBalance(){
		return balance;
	}
	
	public void setBlance(double balance){
		this.balance=balance;
	}
	
	public void withdraw(double amount,int accountNumber)throws Exception{
		if(balance>amount){
			balance=balance-amount;
			System.out.println("Successfuly withdrew "+amount+" from the account "+accountNumber);
		}
		else{
			throw new Exception("Insufficient balance");
		}
	}
	
	public void displayDetails(){
		System.out.println(accountNumber+"\t\t"+accountHolder+"\t\t"+balance);
	}
}

class Bank{
	private BankAccount[] bankaccounts;
	private int no_of_accounts;
	
	Bank(){
		this.bankaccounts=new BankAccount[5];
		this.no_of_accounts=0;
		
	}
	
	public void addBankAccount(BankAccount bankaccount){
		if(no_of_accounts<5){
			bankaccounts[no_of_accounts++]=bankaccount;
		}
		else{
			System.out.println("No of account holders are full.");
		}
	}
	
	public void withdrawMoney(int accountNumber,double amount){
		System.out.println("");
		for(int i=0;i<no_of_accounts;i++){
			if(accountNumber==bankaccounts[i].getAccountNumber() && bankaccounts[i].getBalance()>0){
				try{
					double a=amount;
					bankaccounts[i].withdraw(a,accountNumber);
				}
				catch(Exception e){
					System.out.println("Exception is "+e.getMessage());
				}
				return;
			}
		}
		System.out.println("No account found for account no "+accountNumber);
	}
	
	public void displayAllDetails(){
		System.out.println("");
		if(no_of_accounts==0){
			System.out.println("No accounts in the bank.");
		}
		else{
			for(int i=0;i<no_of_accounts;i++){
				bankaccounts[i].displayDetails();
			}
		}
	}
}

class Main{
	public static void main(String[] args){
		Bank b1=new Bank();
		b1.addBankAccount(new BankAccount(1001,"Alice",5000.00));
		b1.addBankAccount(new BankAccount(1002,"Bob",3000.00));
		b1.displayAllDetails();
		b1.withdrawMoney(1001,6000.00);
		b1.withdrawMoney(1002,1000.00);
		b1.withdrawMoney(1003,1000.00);
		b1.displayAllDetails();
	}
}