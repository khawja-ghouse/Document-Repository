import java.util.Scanner;
class H 
{
	static void print(int from, int to)
	{
		System.out.println(from);
		if (from == to)
		{
			return;
		}
		from++;
		print(from, to);
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the first element:");
		int i  = sc.nextInt();
		System.out.println("enter the Second element:");
		int j  = sc.nextInt();
		print(i,j);
	}
}
