class M13 
{
	public static void main(String[] args) 
	{
		StringBuffer obj1 = new StringBuffer("abc");
		StringBuffer obj2 = new StringBuffer("abc");
		StringBuilder obj3 = new StringBuilder("abc");
		StringBuilder obj4 = new StringBuilder("abc");
		System.out.println(obj1.equals(obj2));
		System.out.println(obj3.equals(obj4));
	}
}
// in string buffer and string builder even though content is same it cannot b overrided