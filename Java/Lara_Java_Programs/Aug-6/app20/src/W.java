class W
{
	void test()
	{
		System.out.println(this);
		System.out.println(super.toString());
	}
	public static void main(String[] args)
	{
		System.out.println(this);
		System.out.println(super.toString());//this and super both cannot be use in the static members
	}
}