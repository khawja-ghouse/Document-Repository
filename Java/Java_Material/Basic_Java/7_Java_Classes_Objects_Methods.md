## Class Fundamentals

Class is a template/BluePrint for an object, and an object is an instance of a class. Because an object is an instance of a class, you will often see the two words object and instance used interchangeably.
The General Form of a Class
A class is declared by use of the class keyword. A simplified general form of a class definition is shown here:

A Java class is like a blueprint for creating objects. It defines the properties and behaviors that the objects created from it will have. Think of it like a recipe: the class specifies what ingredients (variables) and steps (methods) are needed to create a particular dish (object).  

```java
class ClassName { 
 type instance-variable1; 
 type instance-variable2;
 ... 
 type instance-variableN; 
type methodname1(parameter-list) { 
// body of method 
} 
type methodname2(parameter-list) { 
// body of method
 } 
 ... 
type methodnameN(parameter-list) { 
// body of method 
 }
}
```

The data, or variables, defined within a class are called instance variables. The code is contained within methods. Collectively, the methods and variables defined within a class are called members of the class.  

Variables defined within a class are called instance variables because each instance of the class (that is, each object of the class) contains its own copy of these variables. Thus, the data for one object is separate and unique from the data for another.  

All methods have the same general form as main( ), which we have been using thus far. However, most methods will not be specified as static or public. Notice that the general form of a class does not specify a main( ) method. Java classes do not need to have a main( ) method. You only specify one if that class is the starting point for your program. Further, some kinds of Java applications, such as applets, don’t require a main( ) method at all.  

**A simple Class**

Let’s begin our study of the class with a simple example. Here is a class called Box that defines three instance variables: width, height, and depth. Currently, Box does not contain any methods (but some will be added soon). 

```java
    class Box { 
double width; 
double height; 
double depth;
}
```
As stated, a class defines a new type of data. In this case, the new data type is called Box. You will use this name to declare objects of type Box. It is important to remember that a class declaration only creates a template; it does not create an actual object. Thus, the preceding code does not cause any objects of type Box to come into existence.
To actually create a Box object, you will use a statement like the following:


` Box mybox = new Box(); // create a Box object called mybox `

After this statement executes, mybox will be an instance of Box. As mentioned earlier, each time you create an instance of a class, you are creating an object that contains its own copy of each instance variable defined by the class. Thus, every Box object will contain its own copies of the instance variables width, height, and depth. To access these variables, you will use the dot (.) operator.
Here is a complete program that uses the Box class:

```java
/*
 * A program that uses the Box class. Call this file BoxDemo.java
 */
class Box {
	double width;
	double height;
	double depth;
}

//This class declares an object of type Box.
class BoxDemo {
	public static void main(String args[]) {
		Box mybox = new Box();
		double vol;
// assign values to mybox's instance variables
		mybox.width = 10;
		mybox.height = 20;
		mybox.depth = 15;
// compute volume of box
		vol = mybox.width * mybox.height * mybox.depth;
		System.out.println("Volume is " + vol);
	}
}

To run this program, you must execute BoxDemo.class. When you do, you will see the following output: 
Volume is 3000.0
```
Declaring Objects:

As just explained, when you create a class, you are creating a new data type. You can use this type to declare objects of that type. However, obtaining objects of a class is a two-step process. First, you must declare a variable of the class type. This variable does not define an object. Instead, it is simply a variable that can refer to an object. Second, you must acquire an actual, physical copy of the object and assign it to that variable. You can do this using the new operator. The new operator dynamically allocates (that is, allocates at run time) memory for an object and returns a reference to it. This reference is, more or less, the address in memory of the object allocated by new. This reference is then stored in the variable. Thus, in Java, all class objects must be dynamically allocated. Let’s look at the details of this procedure.  

In the preceding sample programs, a line similar to the following is used to declare an object of type Box:  

Box mybox = new Box();  

This statement combines the two steps just described. It can be rewritten like this to show each step more clearly:  
 Box mybox; // declare reference to object  
 mybox = new Box(); // allocate a Box object  

A Closer Look at new As just explained, the new operator dynamically allocates memory for an object.  
It has this general form:  
class-var = new classname ( );

![img.png](../Images/ObjectCreation.png)

The class name followed by parentheses specifies the constructor for the class. A constructor defines what occurs when an object of a class is created. Constructors are an important part of all classes and have many significant attributes. Most real-world classes explicitly define their own constructors within their class definition. However, if no explicit constructor is specified, then Java will automatically supply a default constructor. This is the case with Box. For now, we will use the default constructor.  

It is important to understand that new allocates memory for an object during run time.

