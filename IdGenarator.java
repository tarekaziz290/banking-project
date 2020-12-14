public class IdGenarator
{
	public String new_id;
	public String tem="";
	protected static int serial_no=0;
	String s="";
	public IdGenarator(int year,int month)
	{
		int i=0;
		serial_no++;
		tem=""+serial_no;
		while(i<=5-tem.length()){
			s+="0";
			i++;
		}
		new_id=year+"-"+month+"-"+s+serial_no;
	}
	public String getID()
	{
		return new_id;
	}
}

