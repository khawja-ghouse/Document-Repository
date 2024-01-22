class E
{
	{
		System.out.println("E-IIb");
	}
	E()
	{
		
		System.out.println("D() !");
	}
	static
	{
		System.out.println("SIB");
	}
	public static void main(String[] args) 
	{
		System.out.println("M....B....");
		E e1 = new E();
		System.out.println("............");
		E e2 = new E();
		System.out.println("............");
		E e3 = new E();
		System.out.println("............");
	}
}
