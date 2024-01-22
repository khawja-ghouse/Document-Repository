import java.io.Serializable;

public class Person implements Serializable
{
	//transient int age;//we cannot store transient object inside the file transient is introduced for avoiding the serialization if we want any secuired obj we can go for transient 
	int age;
	//static double weight;//static is  not the part of object while serializing the object static members not serialized 
	double weight;
	Address address;
}
//serializable  is a markup interface
//only for marking purpose we are using this one ...
//conalble and serializable both are marker interface these two are using widely
//no methods are inside the interface
