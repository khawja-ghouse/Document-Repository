class E
{
	private  E()
	{
		System.out.println("E()");
	}
	public static void main(String[] args) 
	{
		E e1 = new E();
		System.out.println("done");
	}
}
/*

E()
done

*/