import java.io.Console;
class M811 
{
	public static void main(String[] args) 
	{
		Console c1 =  System.console();
		System.out.println("enter something");
		char[] data = c1.readPassword();
		String s1 = new String(data);
		System.out.println(s1);
	}
}
