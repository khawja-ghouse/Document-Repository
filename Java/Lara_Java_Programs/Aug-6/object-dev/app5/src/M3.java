class A
{
	int i;
	A(int i)
	{
		this.i = i;
	}
	void perfomClone()
	{
		A a2 = (A) clone();
		System.out.println(a2.i);
	}
}
class  M3
{
	public static void main(String[] args) 
	{
		A a1 = new A(20);
		 a1.perfomClone();
		System.out.println("done");
	}
}
