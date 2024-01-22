class G
{
	public static void main(String[] args) 
	{
		int i=12;
		switch(i)
		{
			case 2:
				System.out.println("from case 2");
				System.out.println(" from case 2");
				break;
			case 4:
				System.out.println(" from case 4");
				System.out.println(" from case 4");
				break;
			case 10:
				System.out.println(" from case 10");
				System.out.println(" from case 10");
			default:
				System.out.println(" from default");
				System.out.println(" from default");
		}	
	}
}
/* no case is executing and control goes to default case at max one default*/
