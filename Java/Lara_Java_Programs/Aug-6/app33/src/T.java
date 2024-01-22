class T 
{
	final int i;
	T()
	{
		i = 10;//re initializing through second constructor
	}
	T(int x)
	{
		this();
		i =20;
	}

}// CTE