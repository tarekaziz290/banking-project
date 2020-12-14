class Saving extends Bank implements Account
{
	public Saving()
	{
		
	}
	public Saving(String name,int day,int month,int year,String nominee,double balance,String password)// parametarizerd conostuctor 
	{
        super(name,day,month,year,nominee,balance,password);
	}
	
	public boolean withdraw(double amount)
	{
		if(amount<=balance&&amount>0){
			balance-=amount;
			return true;
		}
		else{
			System.out.println("Amount Can Not Be (-) or greater than balance");
			return false;   
		}
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
	public String printAccount()
	{
		return "DATE: "+DOB.day+"/"+DOB.month+"/"+DOB.year+"\nID: "+ID.getID()+"\nNAME: "+name+"\nPass:"+password+"\nBALANCE: "+balance+"\nNOMINEE: "+nominee;
	}
}