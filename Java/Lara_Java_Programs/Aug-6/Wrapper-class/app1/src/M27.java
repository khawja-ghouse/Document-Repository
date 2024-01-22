class M27
{
	static void test1(int ... args)
	//data_type ... identifier[ each time this ill acts as array]
	//var arg argument is array by default
	{
		System.out.println("var arg"+args.length);
	}
	
	public static void main(String[] args) 
	{
		test1();
		test1(1);
		test1(2,4);
		test1(40,10,5);
		test1(40,10,5,6);
		System.out.println("--------------");
	}
}
//a method can recive any no of arguments
//A new type of syntax introduced in JDK1.5 which accepts variable no of arguments