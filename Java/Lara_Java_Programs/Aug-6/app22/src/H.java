class H
{
	static int counter;
	H()
	{
		
	}
	H(int i)
	{
		
	}	
	H(int i,int j)
	{
		
	}
	{
		counter++;
	}
	public static void main(String[] arHs) 
	{
		System.out.println("M....B....");
		H h1 = new H();		
		H h2 = new H(10);		
		H h3 = new H();		
		H h4 = new H(1,2);		
		H h5 = new H();		
		H h6 = new H(5);		
		System.out.println(H.counter);
	}
}
//proHram used to count the number of object created for a Hiven class