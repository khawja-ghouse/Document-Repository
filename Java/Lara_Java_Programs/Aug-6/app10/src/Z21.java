class Z21
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		outer:
		for (int i = 1;i <= 5 ; i++ )
		{
			System.out.println("outer loop begin:"+ i );
			abc:
			for (int j = 10; j<= 13 ;j++ )
			{
				System.out.println("inner loop begin:"+ i + ","+ j);
				if (j == 11)
				{
					continue outer;
				}
				System.out.println("inner loop end:"+ i + ","+ j);
			}
			System.out.println("outer loop end:" + i);
			System.out.println(".....................");
		}
		System.out.println("main end");
	}
}
