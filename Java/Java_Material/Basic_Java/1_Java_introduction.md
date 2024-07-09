## Java Busswords or Features of Java

### Object oriented programming:
Java is purely an object-oriented language due to the absence of global scope, everything in java is an object, all the program codes and data resides within classes and objects. It comes with an extensive set of classes, arranged in packages, object model in java in sample and easy to extend. There are seven qualities to be satisfied for a programming language to be pure Object Oriented. They are:
  1.	Encapsulation/Data Hiding
  2.	Inheritance
  3.	Polymorphism
  4.	Abstraction
  5.	All predefined types are objects
  6.	All user defined types are objects
  7.	All operations performed on objects must be only through methods exposed at the objects

  Why Java is not a Pure Object-Oriented Language? 
  1. Primitive Data Type ex. int, long, bool, float, char, etc. as Objects. 
  2. The static keyword:  When we declare a class as static then it can be used without the use of an object in Java. If we are using static function or static variable then we can’t call that function or variable by using dot(.) or class object defying object-oriented feature.

### Platform Independent
In case of C or C++ (language that are not platform independent), the compiler generates an .exe file which is OS dependent. When we try to run this .exe file on another OS it does not run, since it is OS dependent and hence is not compatible with the other OS.
**Java is platform-independent but JVM is platform dependent**
In Java, the main point here is that the JVM depends on the operating system – so if you are running Mac OS X, you will have a different JVM than if you are running Windows or some other operating system. This fact can be verified by trying to download the JVM for your particular machine – when trying to download it, you will be given a list of JVMs corresponding to different operating systems, and you will obviously pick whichever JVM is targeted for the operating system that you are running. So, we can conclude that JVM is platform-dependent and it is the reason why Java is able to become “Platform Independent”.

### Portable:
We can run the same java byte code on any platform (Windows or Linux) without making any changes in java byte code (java program).

### Architecture-Neutral:

The compiler generates an architecture-neutral object file format. The compiled code is executable on many processors, given the presence of the Java runtime system. The Java compiler does this by generating bytecode instructions which have nothing to do with a particular computer architecture. Rather, they are designed to be both easy to  interpret on any machine and easy to translate into native machine code on the fly.

### Secure
Java is secure due to the following reasons:
1. Java programs run inside a virtual machine which is known as a sandbox. 
2. Java does not support explicit pointer. 
3. Byte-code verifier checks the code fragments for illegal code that can violate access right to object. 
4. Run-time security check takes place when we load new code

### Multithreaded: 
Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such program is called a thread. So, threads are light-weight processes within a process.
### Robust:
|  Feature     |   Description      |
|-------|---------|
| Garbage Collection	| Automatic memory management to prevent leaks and optimize performance.|
Exception Handling	|Robust error handling using try, catch, finally, throw, throws.
Strong Typing	|Enforces type safety at compile-time and runtime.
OOP Principles	|Encapsulation, inheritance, and polymorphism for code reusability.
Checked Exceptions	|Forces explicit handling of errors, promoting reliable code.
Memory Management	|Avoids common errors like buffer overflows; no pointers.
Security Features	|Built-in class loaders and security managers for a secure environment.
Rich Standard Library	|Extensive APIs for a wide range of tasks and functionalities.

### Compiled and Interpreted: 
Java is both compiled and interpreted programming language. First java compiler compiles java code and generates machine independent Byte code.
At runtime JVM interprets this byte code into machine specific code and executes that machine code.

### High Performance:
Initially on any computer JVM converts the byte code line by line into the machine language and whichever line that gets converted into machine language computer executes it, this way of running line by line execution is called interpretation this is not a best approach. There is serious problem with performance in this approach so they introduced a JIT (Just in time compilation approach).

    What is JIT?
    Some portion of byte code are very critical – computer keeps on executing these byte code instructions repeatedly again and again for most of its execution time. So, the JVM should convert bytecode of all such critical portion into the machine code for just once and used the already converted code to next time, that saves much time and increase the performance.