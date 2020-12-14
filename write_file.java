import java.io.FileWriter;
import java.io.IOException;
class  write_file extends Bank
{
	static String s;
	public write_file(){
		
	}
	static String information(){
		//.account[] a=super.a;
		s="";
		for(int i=0; i<a.length&&a[i]!=null; i++)
		{
			s=s+a[i].printAccount()+"\n\n";
		}
		return s;
	}
	public void insert_informations_into_file(){
		
	    try{
			FileWriter f=new FileWriter("D:\\Download\\New folder\\test.txt");
		        f.write(information());
			System.out.println("\nInfomation added to database..\n");
			f.close(); 
		}
		catch(Exception e){
			System.out.println("file not create");
			e.printStackTrace();
		}
        }
}
