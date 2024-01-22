class E
{
	int i;
	E()
	{
		i = 100;
	}
	public static void main(String[] args) 
	{
		E e1 = new E();
		E e2 = new E();
		System.out.println(e1.i+","+e2.i);
	}
}
