

import java.io.Console;

public class M711 
{
	public static void main(String[] args) 
	{
		Console c1 =  System.console();
		Console c2 =  System.console();
		Console c3 =  System.console();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
//console obj is creating when even it gets compiled throug interactive command window
//while trigering java command the console obj is created 
// in the program the reference of system.console is been provided