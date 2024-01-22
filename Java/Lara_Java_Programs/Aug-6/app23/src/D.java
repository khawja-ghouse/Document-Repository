class G
{
	int i;
	static int j;
	static void test2()
	{
		System.out.println("G-test2()");
	}
	 void test1()
	{
		System.out.println("G-test1()");
	}

}
class H extends G
{
	int m;
	static int n;
	 void test3()
	{
		System.out.println("H.test3()");
	}
	static void test4()
	{
		System.out.println("H-test4()");
	}
	public static void main(String[] args) 
	{
		H h1 = new H();
		System.out.println(h1.i);
		System.out.println(h1.m);
		System.out.println(H.j);
		System.out.println(H.n);
		h1.test1();
		h1.test3();
		H.test2();
		H.test4();
	}
}//static or non static all the members of super classes are inherited to sub-class
//SIB,IIB and constructors are not inherited to sub class
