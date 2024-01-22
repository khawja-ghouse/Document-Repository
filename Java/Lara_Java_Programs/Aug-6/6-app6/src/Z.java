class  Z
{
	public static void main(String[] args) 
	{
		
		System.out.println("Main begins");
		int i = 0;
		if (i++ == 0 && i++ == 1)
		{
					System.out.println("if1 begins" + i++);
					if(i++ == 2 && i++ == 3)
		
				{		
			System.out.println("if2 begins"+ i++);
			System.out.println("if2 ends");
				}
		System.out.println("if1 end" + i++);
		}
			System.out.println("Main end"+ i );
	}

}
