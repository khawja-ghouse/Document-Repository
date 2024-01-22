class F 
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		Class.forName("");
		System.out.println(2);
	}
}
/*

F.java:6: error: unreported exception ClassNotFoundException; must be caught or declared to be thrown
                Class.forName("");
*/