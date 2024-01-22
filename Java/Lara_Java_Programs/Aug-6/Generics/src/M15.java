class A < Test >
{
	A(Test obj)
	{
	}
}
class M15 
{
	public static void main(String[] args) 
	{
		A<String> a1 = new A<String>("nadeem");
		A<Integer> a2 = new A<Integer>(30);
		A<Double> a1 = new A<Double>(2.5);
		System.out.println("Hello World!");
	}
}
