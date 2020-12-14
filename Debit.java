class Debit extends Bank implements Account
{
	public static double   max_balance=100000;
	public  static  double limit=20000;
	public Debit()
	{
		//defoult constructor
	}
	public Debit(String name,int day,int month,int year,String nominee,double balance,String password)// parametarizerd conostuctor 
	{
	    super(name,day,month,year,nominee,balance,password);
	}
	public boolean deposit(double amount)
	{
		if(amount<=max_balance&&amount<=limit&&amount>0){
			balance+=amount;
			return true;
		}
		else{
			System.out.println("Maximum Deposit 100000 and Single Transaction Limit 20000");
			return false;
		}
	}
	public boolean withdraw(double amount)
	{
		if(amount<=balance&&amount<=limit&&amount>0){
			balance-=amount;
			return true;}
		else{
			System.out.println("Minimum Balance 0 and Single Transaction Limit 20000");
			return false;
		}
	}
	public String printAccount()
	{
		return "DATE: "+DOB.day+"/"+DOB.month+"/"+DOB.year+"\nID: "+ID.getID()+"\nNAME: "+name+"\nPass:"+password+"\nBALANCE: "+balance+"\nNOMINEE: "+nominee;
	}
}
