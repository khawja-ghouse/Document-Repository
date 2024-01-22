class A
{
}
class M9 
{
	public static void main(String[] args) 
	{
		A a1 = null;
		//if the value of the reference is null then it ill not call toString() 
		//in order to avoid nullpointer exception
		String s1 = "some thing" + a1;
		//the + operator checkes both LHS AND RHS if any of them is null 
		//ill not call toString()
		System.out.println(a1);
		System.out.println(s1);
	}
} 
