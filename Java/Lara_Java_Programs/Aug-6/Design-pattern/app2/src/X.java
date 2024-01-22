/*
AAAAA
 BBBB
  CCC
   DD
    E
*/
class  X
{
	public static void main(String[] args) 
	{
		for (char i='A' ; i<='E'; i++ )
		{
			for (char  j='E';j >= i ;j-- )
			{
				System.out.print(i);
			}
			System.out.println();
			for (char k = 'D' ;k >= ('D'+'A' - i) ;k-- )
			{
				System.out.print(" ");
			}
		}
		
	}
}