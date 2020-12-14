class Credit extends Bank implements Account
{
	public  static double min_balance=-100000;
	public  static double single_transaction_limit=20000;
	public  static double max_withdrow=-50000;
	public Credit()
	{
		//defoult constructor
	}
	public Credit(String name,int day,int month,int year,String nominee,double balance,String password)// parametarizerd conostuctor 
	{
        super(name,day,month,year,nominee,balance,password);
	}
	public boolean deposit(double amount)
	{
		if(amount>0){
			balance+=amount;
			return true;
		}
		else{
		System.out.println("Amount Can Not Be Minus(-)");
		return false;   
		}
	}
	public boolean withdraw(double amount)
	{
		//max_withdrow=((-1*min_balance)*(50/100));
		if((balance-amount)>=(max_withdrow)&&amount<=single_transaction_limit)
		{
			balance-=amount;
			return true;
		}
		else{
			System.out.println("Minimum Balance -50000 and Single Transaction Limit 20000");
			return false;
		}
	}
	public String printAccount()
	{
		return "DATE: "+DOB.day+"/"+DOB.month+"/"+DOB.year+"\nID: "+ID.getID()+"\nNAME: "+name+"\nPass:"+password+"\nBALANCE: "+balance+"\nNOMINEE: "+nominee;
	}
}