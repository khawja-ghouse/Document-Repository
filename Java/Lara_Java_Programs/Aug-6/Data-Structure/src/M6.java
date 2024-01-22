class A
{
	int data;
	A ref;
	A(int data)
	{
		this.data = data;
	}
}
class M6
{
	public static void main(String[] args) 
	{
		A a1 = null;
		for(String s1 : args )
		{
			if (a1  == null)
			{
				a1  = new A(Integer.parseInt(s1));
			}
			else
			{
				A element = a1;
				while (element.ref != null)
				{
					element = element.ref;
				}
				element.ref = new A(Integer.parseInt(s1));
			}
		}
		A element = a1;
		while (element != null)
		{
			System.out.println(element.data+",");
			element = element.ref;
		}
	}
}
