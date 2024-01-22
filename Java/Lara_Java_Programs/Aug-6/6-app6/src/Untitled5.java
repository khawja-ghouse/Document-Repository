class  T
{
	public static void main(String[] args) 
	{
		int i = 0;
		System.out.println("Main begins");
		{		
			int i =10;
			System.out.println("if block stm1");
			System.out.println("if block stm2");
			System.out.println("if block stm3");
		}

		{			
			System.out.println("if block stm1"+ i);
			System.out.println("if block stm2");
			System.out.println("if block stm3");
		}
			System.out.println("Main end" );
	}

}
