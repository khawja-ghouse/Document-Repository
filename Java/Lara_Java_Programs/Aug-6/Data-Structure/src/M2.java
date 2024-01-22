class A
{
	int data;

	A(int data)
	{
		this.data = data;//a1.data = data
	}
}
class M2
{
	public static void main(String[] args) 
	{
		A a1 = new A(10);
		A a2 = new A(5);
		A a3 = new A(50);
		A a4 = new A(24);
		System.out.println(a1.data + ","+a2.data + ","+ a3.data + ","+a4.data);
	}
}
