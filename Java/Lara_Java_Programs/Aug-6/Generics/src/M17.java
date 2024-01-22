class A < X extends R>
{
	X obj;
}
class M17
{
	public static void main(String[] args) 
	{
		A<R> a1 = new A<R>();//you can specify only R type or sub type of R
		A<S> a1 = new A<S>();
		A<T> a1 = new A<T>();
	}
}