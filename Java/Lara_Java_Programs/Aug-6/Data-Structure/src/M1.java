class A
{
	int data;
} 
class M1
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.data  = 10;
		A a2 = new A();
		a2.data  = 5;
		A a3 = new A();
		a3.data  = 50;
		A a4 = new A();
		a4.data  = 20;
		System.out.println(a1.data + ","+a2.data + ","+ a3.data + ","+a4.data);
	}
}
