class U

{
	static int  i =test1();
	static int  j = i + test1();
	static int  k =i + j +test1();
	 public static int test1()
	{
		System.out.println("test:"+i+","+j+","+k);
		i += 1;
		j += 2;
		k += 3;
		return i + j + k;
	}
	public static void main(String[] args) 
	{
		System.out.println("main"+i+","+j+","+k);
	}
}
