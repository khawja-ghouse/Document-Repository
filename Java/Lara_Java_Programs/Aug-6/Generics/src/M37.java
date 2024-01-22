class A < X >
{
	void test(X arg)
	{

	}
}
class M37
{
	public static void main(String[] args) 
	{
		A< ? extends Number> a1 = null;	
		a1 = new A<Integer>();
		a1.test(10);//ambiguity bec it can be Number or any subclass to Number
		System.out.println("Hello...");
	}
}
