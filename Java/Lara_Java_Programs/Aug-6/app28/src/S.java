interface A
{
	void test1();
}

class S implements A
{
	public void test1(int i)
	{
		System.out.println("from test1(int)!");
	}
	public static void main(String[] args) 
	{
		S s1 = new S();
		s1.test1();
		System.out.println("DON!");
	}
}

//here we are not overriding the the abstract method rather ve are overloading  the signature of the abstract method 
//