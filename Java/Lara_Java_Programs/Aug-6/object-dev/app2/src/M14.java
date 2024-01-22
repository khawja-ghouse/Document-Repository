import java.util.ArrayList;
class M14
{
	public static void main(String[] args)
	{
		ArrayList list1 = new ArrayList();
		list1.add(90);
		list1.add("abc");
		list1.add(9.5);
		ArrayList list2 = new ArrayList();
		list2.add(90);
		list2.add("abc");
		list2.add(9.5);
		System.out.println(list1.equals(list2));
	}
}
//in every class of collection api equals methods override 