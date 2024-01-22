class Z2
{
	 enum Test {CON1,CON2,CON3,CON4};
	public static void main(String[] args) 
	{
		Test t1 = Test.CON1;
		switch(t1)
		{
			case 0:
				System.out.println("from CON1");
				break;
			case 1:
				System.out.println("from CON2");
				break;			
			case 2:
				System.out.println(" from CON3");
				break;
			case 3:
				System.out.println(" from CON4");
		}	
	}
}/* compilation error bec we cant use the unique index value for the case value */