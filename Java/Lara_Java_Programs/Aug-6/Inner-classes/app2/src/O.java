class O 
{
	public static void main(String[] args) 
	{
		int i = 10;
		 final int j = 10;
		 class A
		 {
			 void test()
			 {
					System.out.println(i);//here i should  be  acting as a final hence when no reinitialization no error
					System.out.println(j);// if u are initializin then error bec i ill  be acting as final
			 }
		 }
		 //i =10;
		System.out.println("Hello World!");
	}
}
//while v r using local varial inside a local innerclass local variable should act as final 