class I
{
	static int i = test();
	static int j = test();
	static int k = test();

	static
	{
		System.out.println("SIB1:"+ i + ","+ j + "," + k);
		i += i + j + k  + 1;
		j += i + j + k  + 2;
		k += i + j + k  + 3;
	}
	
	public static int test()
	{
		System.out.println("test" +i+","+j+","+k);
		i += i + j + k  + 1;
		j += i + j + k  + 2;
		k += i + j + k  + 3;
		return i + j + k + 4;
	}
	public static void main(String[] args) 
	{
		System.out.println("main");
		System.out.println("test" +i+","+j+","+k);
	}	
	static
	{
		System.out.println("SIB2:"+ i + ","+ j + "," + k);
		i += i + j + k  + 1;
		j += i + j + k  + 2;
		k += i + j + k  + 3;
	}
}
