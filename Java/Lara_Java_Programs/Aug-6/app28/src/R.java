interface A
{
	void test1();
}
class B implements A
{
	public void test1()
	{
		System.out.println("from testB()!");
	}
}
class R extends B implements  A
{
	/*public void test1()
	{
		System.out.println("from R()!");
	}*/
	public static void main(String[] args) 
	{
		R r1 = new R();
		r1.test1();
		System.out.println("DON!");
	}
}

//A method automatically geting implemented through B method bec U are extending B  in R class
//There is no need of again implementation of A in R class