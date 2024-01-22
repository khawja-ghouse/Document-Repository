class A
{
	int data;
	A ref;
	A(int data)
	{
		this.data = data;
	}
}
class M4
{
	public static void main(String[] args) 
	{
		A a1 = new A(10);
		a1.ref = new A(5);
		a1.ref.ref = new A(50);
		a1.ref.ref.ref = new A(24);
		System.out.println(a1.data + ","+a1.ref.data + ","+ a1.ref.ref.data + ","+a1.ref.ref.ref.data);
	}
}
