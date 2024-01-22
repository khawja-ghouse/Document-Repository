class Q2 
{
	public static void main(String[] args) 
	{
		int x = 10;
		char[] chars = new char[x];
		char a='a';
		for (int i = 0;i < x ;i++)
		{
			chars[i] = a;
			chars[chars.length - 1 - i] = a;
			for (int j = 0;j < x   ;j++ )
			{
				if ((j == i || j == x-i-1))
				{
					
					continue;
				}
				chars[j] = ' ';
			}
			a++;
			System.out.println(new String(chars));

		}
		
	}
}
