package pack1;
class  G
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		assert test();//assert return type is boolean :hence it ill finally accept either true or false
		System.out.println(2);
	}
	static boolean test()
	{
		return true;
	}
}