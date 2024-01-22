class A < X extends Number >
{
	X obj;
}
class M19
{
	public static void main(String[] args) 
	{
		A< Integer > a1 = new A<Integer>();
		A< String > a2 = new A<String>();
		System.out.println("Hello World!");
	}
}