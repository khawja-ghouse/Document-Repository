class D 
{
	static void test(int i)
	{
		System.out.println("test begin:"+i);
		if (i ==4)
		{
			return;
		}
		i++;//pre execution (going forward )
		test(i);//self method invocation/Execution is called Recursion
		System.out.println("test end:"+ i);//post execution (while coming backward)
	}
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		test(1);
		System.out.println("main end");
	}
}
//in the recursive algorith the return statm is mandatory in the pre  else v ill get a never end execution 