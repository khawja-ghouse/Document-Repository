interface A
{
	void test1();
}
class K implements A 
{
	public void test1()
	{
		System.out.println("from K.A!");
	}
	public static void main(String[] args) 
	{
		//A a1 = new A() v cannot create a object to the interface 
		A a2 = null;// But v can create a reference to the interface;For the datatype purpose v can use a interface
		K k1 = new K();
		k1.test1();
		System.out.println("DON!");
	}
}
//