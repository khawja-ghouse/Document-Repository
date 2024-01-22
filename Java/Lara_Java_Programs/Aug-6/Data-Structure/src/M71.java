import java.util.Scanner;
class A
{
	int data;
	A ref;
	A(int data)
	{
		this.data = data;
	}
}
class M71
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		A a1 = null;
		System.out.println("do you want to insert the data yes/no");
		String s1 = sc.nextLine();
		String s2 ="yes";
		if (s1.equals(s2))
		{
			System.out.println("enter the first element");
			int b = sc.nextInt();
			if (a1  == null)
			{
				a1  = new A((b));
			}
		}
		do
		{
			System.out.println("enter the next element you want to insert");
			int b = sc.nextInt();
				A element = a1;
				while (element.ref != null)
				{
					element = element.ref;
				}
				element.ref = new A(b);
				System.out.println("do you want to continue for insert the data yes/no");
		}
		while ("y".equals(sc.next()));
		A element = a1;
		while (element != null)
		{
			System.out.println(element.data+",");
			element = element.ref;
		}
	}
}
