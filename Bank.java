import java.util.Scanner;

class Bank implements Account
{
	protected IdGenarator ID;
	protected Date DOB;
	
	protected String name;
	protected String nominee;
	protected double balance ;
	protected String password;
	static Bank[] a=new Bank[10];
	String admin_password="admin";
	static int i;// bank[] a index
	
	public Bank()// default constructor
	{
	    
	}
	public Bank(String name,int day,int month,int year,String nominee,double balance,String password)
	{
	this.DOB=new Date(day,month,year);
	this.ID=new IdGenarator(year,month);

	this.name=name;
	this.nominee=nominee;
	this.balance=balance;
	this.password=password;
	}
	public int check_pass(String pass,String id)// return index
	{
	    //System.out.println("pass="+pass);
	    int j=-1;
	    for(int k=0;k<a.length&&a[k]!=null;k++){
	        if(pass.equals(a[k].password)&&id.equals(a[k].ID.getID()))
	            return k;
	    }
	    return j;
	}
	public String printAccount(){return null;}
	public boolean withdraw(double amount){return false;}
	public boolean deposit(double amount){return false;}
    
    
	public static void main (String args[])///  main
	{
		int type,menu;
		String pass,id;
		int day,month,year;
		double amount; 
		boolean t_f;
		Scanner scan=new Scanner(System.in);
		Bank b=new Bank();
		write_file f=new write_file();
		Read_file r=new Read_file();
		//System.out.println;
		while(true)
		{
			System.out.println(" 1)Create Account  2)Log in  3)Read From File(for Admin)  0)Exit\n");
			menu=scan.nextInt();
			if(menu==0){
				break;
			}
			else if(menu==1)// create account
			{
				System.out.println("Type of Accounts 1)Credit  2)Debit  3)Saving ");
				type=scan.nextInt();
				
				System.out.println("Please give some information..\n");
				System.out.print("Name:");
				b.name=scan.next();
				System.out.print("Password:");
				pass=scan.next();
				System.out.print("Enter Today's Day:");
				day=scan.nextInt();
				System.out.print("Enter Running Month:");
				month=scan.nextInt();
				System.out.print("Enter Running Year:");
				year=scan.nextInt();
				b.balance=0;
				while(b.balance<500){
					System.out.print("Initial Balance(Minimum 500 BDT):");
					b.balance=scan.nextDouble();
				}
				System.out.print("nominee:");
				b.nominee=scan.next();
				if(type==1){
					a[i]=new Credit(b.name,day,month,year,b.nominee,b.balance,pass);
					f.insert_informations_into_file();// file write
					System.out.println("Remember Your ID:"+a[i].ID.getID());
					i++;
				}
				else if(type==2){
					a[i]=new Debit(b.name,day,month,year,b.nominee,b.balance,pass);
					f.insert_informations_into_file();// file write
					System.out.println("Remember Your ID:"+a[i].ID.getID());
					i++;
				}
				else if(type==3){
					a[i]=new Saving(b.name,day,month,year,b.nominee,b.balance,pass);
					f.insert_informations_into_file();// file write
					System.out.println("Remember Your ID:"+a[i].ID.getID());
					i++;
				}
				else{
					System.out.println("Wrong input!!!");
					System.out.println("account not create!!!");
				}
				System.out.println();
			}
			else if(menu==2)//withdraw,deposit,show balance
			{
				System.out.print("Enter Your Id: ");
				id=scan.next();
				System.out.print("User Password: ");
				pass=scan.next();
				if(b.check_pass(pass,id)!=-1){
					int index=b.check_pass(pass,id);
					while(true){
						System.out.println("  1.Deposit\n  2.Withdraw\n  3.Show Balance\n  0.Log Out\n");
						menu=scan.nextInt();
						if(menu==0)break;
					    
						else if(menu==1)// 1.Deposit
						{
							System.out.print("Amount:");
							amount=scan.nextDouble();
							t_f=a[index].deposit(amount); 
							if(t_f==true){
								System.out.println("\nDeposit Success...\n");
							}
							else
								System.out.println("\nDeposit Failed !!!\n"); 
						}
						else if(menu==2)//  2.Withdraw1
						{
							System.out.print("Amount:");
							amount=scan.nextDouble();
							t_f=a[index].withdraw(amount); 
							if(t_f==true){
							    System.out.println("\nWithdraw Success...\n");
							}
							else
							   System.out.println("\nWithdraw Failed !!!\n"); 
						}
						else if(menu==3)// 3.show balance
						{
							System.out.println("Your Current Balance = "+a[index].balance+" BDT\n");
						}
					}
				}
				else{
					System.out.println("Invalid Id or Password !!!");
				}
			}
			else  if(menu==3)// file read
			{
				System.out.print("Admin Password:");//admin
				pass=scan.next();
				if(pass.equals(b.admin_password)){
					System.out.println(r.getFileData());
				}
				else{
					System.out.println("Password Incorect!!!");
				}
			}
			else{
				System.out.println("Wrong input!!!");
			}
		}
        }
}