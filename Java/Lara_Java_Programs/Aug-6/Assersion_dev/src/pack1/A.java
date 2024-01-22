package pack1;
class  A
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		assert true;//no assert error bec by default assert stm not executing
		System.out.println(2);
	}
}
//in order to enable assersion v have to provid -ea
/*
F:\Aug-6\Assersion_dev\src>java -cp ../classes pack1.A
1
2

F:\Aug-6\Assersion_dev\src>java -cp ../classes -ea pack1.A
1
2
	*/