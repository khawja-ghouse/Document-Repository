package com.lara;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class E implements Serializable
{
	static int i;
	transient int j;
	private void writeObject(ObjectOutputStream out)throws IOException, ClassNotFoundException
	{
		System.out.println("from write object");
		out.defaultWriteObject();
		out.writeInt(j);
	}
	
	
	private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException
	{
		System.out.println("from write object");
		in.defaultReadObject();
		System.out.println(in.readInt());
	}


}
