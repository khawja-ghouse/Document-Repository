class G
{
	G(int i)
	{		
		System.out.println("G(int)");
	}
	G()
	{		
		System.out.println("G()");
	}
	public static void main(String[] args) 
	{
		G g1 = new G(20);
		System.out.println("......");
		G g2 = new G();
		System.out.println(".......");
	}
}
