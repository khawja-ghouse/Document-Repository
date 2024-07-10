## A Closer Look at Methods and Classes

### Overloading Methods:  
In Java, it is possible to define two or more methods within the same class that share the same name, as long as their parameter declarations are different. When this is the case, the methods are said to be overloaded, and the process is referred to as method overloading.
When an overloaded method is invoked, Java uses the type and/or number of arguments as its guide to determine which version of the overloaded method to actually call. Thus, overloaded methods must differ in the type and/or number of their parameters. While overloaded methods may have different return types, the return type alone is insufficient to distinguish two versions of a method

```java
//Demonstrate method overloading.
class OverloadDemo {
	void test() {
		System.out.println("No parameters");
	}

// Overload test for one integer parameter.
	void test(int a) {
		System.out.println("a: " + a);
	}

// Overload test for two integer parameters.
	void test(int a, int b) {
		System.out.println("a and b: " + a + " " + b);
	}

// Overload test for a double parameter
	double test(double a) {
		System.out.println("double a: " + a);
		return a * a;
	}
}

class Overload {
	public static void main(String args[]) {
		OverloadDemo ob = new OverloadDemo();
		double result;
// call all versions of test()
		ob.test();
		ob.test(10);
		ob.test(10, 20);
		result = ob.test(123.25);
		System.out.println("Result of ob.test(123.25): " + result);
	}
}

// This program generates the following 
// output:
No parameters 
a: 10
a and b: 10 20
double a: 123.25
Result of ob.test(123.25): 15190.5625

```

However, this match need not always be exact. In some cases, Java’s automatic type conversions can play a role in overload. Java will employ its automatic type conversions only if no exact match is found. Method overloading supports polymorphism because it is one way that Java implements the “one interface, multiple methods” paradigm.

Using Objects as Parameters.
So far, we have only been using simple types as parameters to methods. However, it is both correct and common to pass objects to methods. For example, consider the following short program:

```java
//Objects may be passed to methods.
class Test {
	int a, b;

	Test(int i, int j) {
		a = i;
		b = j;
	}

// return true if o is equal to the invoking object
	boolean equalTo(Test o) {
		if (o.a == a && o.b == b)
			return true;
		else
			return false;
	}
}

class PassOb {
	public static void main(String args[]) {
		Test ob1 = new Test(100, 22);
		Test ob2 = new Test(100, 22);
		Test ob3 = new Test(-1, -1);
		System.out.println("ob1 == ob2: " + ob1.equalTo(ob2));
		System.out.println("ob1 == ob3: " + ob1.equalTo(ob3));
	}
}

This program generates the following output:
 ob1 == ob2: true 
ob1 == ob3: false

```

**A Closer Look at Argument Passing:**  
In general, there are two ways that a computer language can pass an argument to a subroutine. The first way is call-by-value. This approach copies the value of an argument into the formal parameter of the subroutine. Therefore, changes made to the parameter of the subroutine have no effect on the argument. The second way an argument can be passed is call-by-reference. In this approach, a reference to an argument (not the value of the argument) is passed to the parameter. Inside the subroutine, this reference is used to access the actual argument specified in the call. This means that changes made to the parameter will affect the argument used to call the subroutine. As you will see, although Java uses call-by-value to pass all arguments, the precise effect differs between whether a primitive type or a reference type is passed. When you pass a primitive type to a method, it is passed by value. Thus, a copy of the argument is made, and what occurs to the parameter that receives the argument has no effect outside the method.

Java Pass By Reference And Pass By Value

There are basically two types of techniques for passing the parameters in Java. The first one is pass-by-value and the second one is pass-by-reference. One thing to remember here is that when a primitive type is passed to a method, then it is done by the use of pass-by-value.
However, all the non-primitive types that include objects of any class are always implicitly passed by use of pass-by-reference. Basically, pass-by-value means that the actual value of the variable is passed and pass-by-reference means the memory location is passed where the value of the variable is stored.
In this example, we will showcase how to pass a parameter by using pass-by-value which is also known as call-by-value. Here we have initialized a variable ‘a’ with some value and used the pass-by-value technique to show how the value of the variable remains unchanged. In the next segment, we will try to show a similar example, but we will use non-primitives.


```java 
public class Example {
     
    /*
     *  The original value of a will remain unchanged in
     *  case of call-by-value
     */
     
    int a = 10;
    void call(int a) {
         
        // this local variable a is subject to change in its value
        a = a+10;
    }
     
    public static void main(String[] args) {
        Example eg = new Example();
        System.out.println("Before call-by-value: " + eg.a);
         
        /*
         * Passing an integer 50510 to the call() method. The value of 
         * 'a' will still be unchanged since the passing parameter is a 
         * primitive type. 
         */
        eg.call(50510);
        System.out.println("After call-by-value: " + eg.a);        
    }
}

Output: 
Before call-by-value: 10
After call-by-value: 10

```

Java Passing Object:  
Pass by Reference Example
In this example, we will see how to pass any object of a class using pass-by-reference.
As you can see, when we have passed the object reference as a value instead of a value, the original value of the variable ‘a’ is changed to 20. This is because of the changes in the called method.

```java
public class Example {
    /*
     *  The original value of 'a' will be changed as we are trying
     *  to pass the objects. Objects are passed by reference.
     */ 
    int a = 10;
    void call(Example eg) {
        eg.a = eg.a+10;
    }
    public static void main(String[] args) {
        Example eg = new Example();
        System.out.println("Before call-by-reference: " + eg.a);
        // passing the object as a value using pass-by-reference
        eg.call(eg);
        System.out.println("After call-by-reference: " + eg.a);
    }
}
Output:

Before call-by-reference: 10
After call-by-reference: 10

```
### Recursion  
Java supports recursion. Recursion is the process of defining something in terms of itself. As it relates to Java programming, recursion is the attribute that allows a method to call itself. A method that calls itself is said to be recursive. The classic example of recursion is the computation of the factorial of a number. The factorial of a number N is the product of all the whole numbers between 1 and N. For example, 3 factorial is 1 × 2 × 3 ×, or 6. Here is how a factorial can be computed by use of a recursive method:

```java
//A simple example of recursion.
class Factorial {
// this is a recursive method
	int fact(int n) {
		int result;
		if (n == 1)
			return 1;
		result = fact(n - 1) * n;
		return result;
	}
}

class Recursion {
	public static void main(String args[]) {
		Factorial f = new Factorial();
		System.out.println("Factorial of 3 is " + f.fact(3));
		System.out.println("Factorial of 4 is " + f.fact(4));
		System.out.println("Factorial of 5 is " + f.fact(5));
	}
}

The output from this program is shown here: 
Factorial of 3 is 6 
Factorial of 4 is 24 
Factorial of 5 is 120

```
