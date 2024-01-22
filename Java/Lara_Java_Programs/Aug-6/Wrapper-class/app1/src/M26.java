class M26
{
	static void test1(int ... arg)
	{
		System.out.println("var arg");
	}
	
	public static void main(String[] args) 
	{
		test1();
		test1(1);
		test1(2,4);
		test1(40,10);
		System.out.println("--------------");
	}
}
//a method can recive any no of arguments
//A new type of syntax introduced in JDK1.5 which accepts variable no of arguments