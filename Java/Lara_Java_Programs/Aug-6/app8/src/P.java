class P
{
	public static void main(String[] args) 
	{
		byte i=12;
		switch(i)
		{
			case 2:
				System.out.println("from case2");
				break;
			case 140:
				System.out.println("from case4");
				break;			
			case 12:
				System.out.println(" from case12");
				
			default:
				System.out.println("from 2nd default");
				break;
		}	
	}
}
/* Every case value should take a byte value bec switch is byte type*/