package pack1;
import pack1.pack11.M;
import pack2.N;
import pack2.pack22.O;
class  L
{
	public static void main(String[] args) 
	{ 
		System.out.println(1);
		assert false;
		System.out.println(2);
		pack1.pack11.M.test2();
		System.out.println(3);
		pack2.pack22.O.test4();
		System.out.println(4);
		pack2.N.test3();
		System.out.println(5);
	}
}
/*
1.java -cp ../classes -ea:pack2... pack1.L
//enable in the pack2 and sub packages of pack2 (pack2.pack22) members

2.java -cp ../classes -ea:pack2.N pack1.L
	//enable only in the N class

3.java -cp ../classes -ea -da:pack1... pack1.L
//enable in the pack2 and sub packages of pack2 (pack2.pack22) members

4.java -cp ../classes -ea -da:pack1... -da:pack2.pack22.O pack1.L
//enable only in the N classes

*/