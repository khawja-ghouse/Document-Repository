class C  
{
	static void test(int i)
	{
		if(i == 11)
		{
			return;
		}
		System.out.println("helloooo");
		i++;
		test(i);
	}
	public static void main(String[] args) 
	{
		test(1);
	}
}
//Inorder to develop global Re usability ==> call just test(1) where ever v want to  10 itirations 