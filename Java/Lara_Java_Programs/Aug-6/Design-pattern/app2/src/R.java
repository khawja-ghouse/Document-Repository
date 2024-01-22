/*
    A
   BB
  CCC
 DDDD
EEEEE
*/



class  R
{
	public static void main(String[] args) 
	{
		for (char  i='A' ; i<= 'E'; i++ )
		{
			for (char k = 'A' ;k <= ('E' + 'A' - 1 - i) ;k++ )
			{
				System.out.print(" ");
			}
			for (char  j='A';j <= i ;j++ )
			{
				System.out.print(i);
			}
			System.out.println();
		}
		
	}
}