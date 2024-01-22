class Z1
{
	 enum Test {CON1,CON2,CON3,CON4};
	public static void main(String[] args) 
	{
		Test t1 = Test.CON1;
		Test t2 = Test.CON2;
		Test t3 = Test.CON3;
		Test t4 = Test.CON4;
		switch(t1)
		{
			case CON1:
				System.out.println("from CON1");
				break;
			case 1:
				System.out.println("from CON2");
				break;			
			case CON3:
				System.out.println(" from CON3");
				break;
			case CON4:
				System.out.println(" from CON4");
		}	
	}
}