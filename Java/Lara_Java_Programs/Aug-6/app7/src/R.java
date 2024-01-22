class  R
{
	public static void main(String[] args) 
	{

		System.out.println("main begin");
		
		if (true)
			{
			  System.out.println("if1 begin");
			
		    if (false)
		               if (true) 
			                 System.out.println("if3");
						else
							System.out.println("else  3");

		   else
			   
			        System.out.println("else 2");
			        System.out.println("if1 end");
		       
			}
        else
			  {
			        System.out.println("else 1");
		       }

		System.out.println("main end");
	}
}
