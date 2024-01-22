package pack1;
class  H
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		assert test();//assert return type is boolean :hence it ill finally accept either true or false
		System.out.println(2);
	}
	static int test()
	{
		return 10;
	}
}
//cte int cannot be converted to boolean 7