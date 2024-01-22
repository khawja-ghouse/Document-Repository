class G 
{
	static void test(int i,int j)
	{
		int a = i;
		int b = j;
		if(a < b)
		{
			
			if( i == j + 1)
			{
				return;
			}
			System.out.println(i);
			i++;
			test(i,j);
		}
		if( a > b)
		{
			if( j == 0)
			{
				return;
			}
			System.out.println(i);
			--i;
			--j;
			test(i,j);
		}

	}
	public static void main(String[] args) 
	{
		if (args.length < 2)
		{
			System.out.println(" pls enter the two ranges ");
			return;
		}
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		test(a,b);
	}
}
