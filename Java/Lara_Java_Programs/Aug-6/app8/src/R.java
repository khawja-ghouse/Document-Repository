class R
{
	public static void main(String[] args) 
	{
		short i=12;
		switch(i)
		{
			case 2:
				System.out.println("from case2");
				break;
			case 40000:
				System.out.println("from case4");
				break;			
			case 12:
				System.out.println(" from case12");
				break;
			default:
				System.out.println("from 2nd default");
				break;
		}	
	}
}