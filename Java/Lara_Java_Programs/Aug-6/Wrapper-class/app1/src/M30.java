class M30
{
	public static void test1(String x,double ... y)//data_type ... identifier[ each time this ill acts as array]
	{
		System.out.println(x);
		for ( double value : y)
		{
			System.out.println(value);
		}
		System.out.println(".............");
	}
	
	public static void main(String[] args) 
	{
		test1("abc");
		test1("abc",4.5);
		test1("def",2,4);
		test1("abc",40,10,5);
		System.out.println("--------------");
	}
}
//a method can recive any no of arguments
//A new type of syntax introduced in JDK1.5 which accepts variable no of arguments