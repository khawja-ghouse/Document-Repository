class  J
{
	public static void main(String[] args) 
	{

		System.out.println("main begin");
		int i = 0;
		if (i++ == 0){
			System.out.println("if block stm1");
			i =i + 2;
		}
		else{
			System.out.println("else block stm1");
			i = i + 3;
		}

		System.out.println("main end"+ i);
	}
}
