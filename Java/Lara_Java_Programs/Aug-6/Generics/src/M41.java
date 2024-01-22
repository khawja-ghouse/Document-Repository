class A <T> 
{
	T obj;
}
class M41
{
	public static void main(String[] args) 
	{
		 A<?> a1 = null;
		 a1 = new A<Number>();
		 a1.obj = 20;
		 System.out.println("Hello World!");
	}
}
