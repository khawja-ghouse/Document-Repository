class A
{
	int i;
}
class M3
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.i = 10;
		A a2 = a1;
		System.out.println(a1);
		System.out.println(a2);
	}
}