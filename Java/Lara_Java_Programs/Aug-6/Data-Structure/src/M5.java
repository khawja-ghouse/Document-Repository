class A
{
	int data;
	A ref;
	A(int data)
	{
		this.data = data;
	}
}
class M5
{
	public static void main(String[] args) 
	{
		A a1 = new A(10);
		a1.ref = new A(5);
		a1.ref.ref = new A(50);
		a1.ref.ref.ref = new A(24);
		a1.ref.ref.ref.ref = new A(14);
		a1.ref.ref.ref.ref.ref = new A(21);

		A element = a1;
		while (element != null)
		{
			System.out.println(element.data+",");
			element = element.ref;
		}
	}
}
