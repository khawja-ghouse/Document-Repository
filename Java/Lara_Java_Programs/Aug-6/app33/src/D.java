class  D
{ 
	int i;
	public static void main(String[] args) 
	{
		D d1 = new D();
		d1.i =10;

		final D d2 = new D();
		d2.i = 10;

		d1.i = 10;
		d2.i = 10;
		System.out.println("Hello World!");
	}
}
