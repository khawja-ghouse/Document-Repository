class  M
{
	public static void main(String[] args) 
	{

		System.out.println("main begin");
		
		if (true)
			{
			  System.out.println("if1 begin");
			
		   if (true)
				{
			        System.out.println("if2 begin");
				
		               if (false) 
						   {
			                 System.out.println("if3");
			
		                   }
						else
					       {
							System.out.println("else  3");
					       }
				}
		   else
			  {
			        System.out.println("else 2");
		      }
			}
        else
			  {
			        System.out.println("else 3");
		      }

		System.out.println("main end");
	}
}
