class A <T> 
{
	T obj;
}
class M40
{
	public static void main(String[] args) 
	{
		 A<?> a1 = null;
		 a1 = new A<Number>();
		 a1 = new A<String>();
		 a1 = new A<Integer>();
		System.out.println("Hello World!");
	}
}
