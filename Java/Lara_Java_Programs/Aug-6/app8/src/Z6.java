class Z6
{
	public static void main(String[] args) 
	{
		String s1= "abc";
		switch(s1)
		{
			case 96354:/* cmp error bec switch arg is is a string type all the cases should have string*/
				System.out.println("from case abc");
				break;
			case "xyz":
				System.out.println("from case xyz");
				break;			
			case "hello":
				System.out.println(" from case hello");
				break;
		}	
	}
}