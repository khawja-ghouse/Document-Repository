import java.io.Closeable;
class H implements Closeable
{
	public void close() 
	{
		System.out.println("close");
	}
}
//closeable interface comes under functionl interface =>bec Closable have only one abstract method