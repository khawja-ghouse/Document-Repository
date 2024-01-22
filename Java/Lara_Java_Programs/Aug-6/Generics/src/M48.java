class A <T> 
{
	T obj;
}
class M48
{

	public static void main(String[] args) 
	{
		A<? extends Number> a1 = new A<Integer>();
		a1.obj = 8000; 
		System.out.println("Hello World!");
	}
}

