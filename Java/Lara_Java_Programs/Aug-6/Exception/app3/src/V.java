class V 
{
	V() throws ClassNotFoundException
	{
		System.out.println("v()");
	}
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		V v1 = new V();
		System.out.println("main end");
	}
}