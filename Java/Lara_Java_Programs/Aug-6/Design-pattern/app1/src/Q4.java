class Q4 
{
	public static void main(String[] args) 
	{
		int x = 7;
		char[] chars = new char[x];
		//char a='a';
		for (int i = 0;i < x ;i++)
		{
			chars[i] = '1';
			chars[chars.length - 1 - i] = '1';
			for (int j = 0;j < x   ;j++ )
			{
				if ((j == i || j == x-i-1))
				{				
					continue;
				}
				chars[j] = ' ';
			}
			System.out.println(new String(chars));
		}
	}
}
