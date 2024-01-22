class M35 
{
	public static void main(String[] args) 
	{
		C c1 = new D();
		System.out.println(c1 instanceof Object);
		System.out.println(c1 instanceof A);
		System.out.println(c1 instanceof B);
		System.out.println(c1 instanceof C);
		System.out.println(c1 instanceof D);
		System.out.println(c1 instanceof E);
		System.out.println(c1 instanceof String);
	}
}
