class M54 
{
	public static void main(String[] args) 
	{
		ThreadPoolManager tp = new ThreadPoolManager();
		tp.init();
		Customer1 c1 = new Customer1(tp);
		c1.start();		
		Customer2 c2 = new Customer2(tp);
		c2.start();		
		Customer3 c3 = new Customer3(tp);
		c3.start();
		Util.sleep(50000);
		c1.stop();
		c2.stop();
		c3.stop();
		tp.release();
		System.out.println("END OF THE GAME");
	}
}
