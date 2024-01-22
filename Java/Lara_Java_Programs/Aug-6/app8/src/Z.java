class Z
{
	 enum Test {CON1,CON2,CON3,CON4};

	public static void main(String[] args) 
	{
		Test t1 = Test.CON1;
		Test t2 = Test.CON2;
		Test t3 = Test.CON3;
		Test t4 = Test.CON4;
		System.out.println(t1  + ":" +t1.ordinal());
		System.out.println(t2  + ":" +t2.ordinal());
		System.out.println(t3  + ":" +t3.ordinal());
		System.out.println(t4  + ":" +t4.ordinal());
		
	}
}