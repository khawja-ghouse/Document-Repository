class A
{
	int i;
}
class B extends A
{
	//int i;
	int j;
	public static void main(String[] args) 
	{
		B b1 =new B();
		System.out.println(b1.j);
		System.out.println(b1.i);
	}
}
