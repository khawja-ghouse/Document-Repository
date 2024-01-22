class A
{
	int data;
	A ref;
	A(int data)
	{
		this.data = data;
	}
}
class M3
{
	public static void main(String[] args) 
	{
		A a1 = new A(10);
		A a2 = new A(5);
		A a3 = new A(50);
		A a4 = new A(24);
		a1.ref  = a2;
		a2.ref  = a3;
		a3.ref  = a4;
		System.out.println(a1.data + ","+a2.data + ","+ a3.data + ","+a4.data);
		System.out.println(a1.data + ","+a1.ref.data + ","+ a1.ref.ref.data + ","+a1.ref.ref.ref.data);
	}
}
