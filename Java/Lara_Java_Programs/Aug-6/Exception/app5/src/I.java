class  I
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");


		try(H h1 = new H();
			H h2 = new H())//JDK 1.7
		{
			System.out.println("from try");
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			System.out.println("from finally");
		}
		System.out.println("main begin");
	}
}
// any number of closable can be opned in try parantheses

// This type of closing a object as h1 and h2 is called as ARC(auto resource closing)
//1.which ever resource u r trying to opening thet should be closable type
//2.ds closable resource act as local to cosable
//3.h1 and h2 both cannot  be re initialined  in the body both ill be acting as final