class M
{
	public static void main(String[] args) 
	{
		int i=20;
		switch(i)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 9:
				System.out.println("odd number");
				break;
			case 2:
			case 4:
			case 6:
			case 8:
			case 10:
				System.out.println(" even number");
				break;
			default:
				System.out.println("number should between 1 to 10");	
		}	
	}
}