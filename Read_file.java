import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Read_file
{
	static String s;
	static String getFileData(){
		s="";
		try{
			File f=new File("Bank_database.txt");
			Scanner input=new Scanner(f);
			
			while(input.hasNextLine()){
				s+=input.nextLine()+"\n";
			}
		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("\nCraeate Account Please..");
		}
		return s;
	}	
}