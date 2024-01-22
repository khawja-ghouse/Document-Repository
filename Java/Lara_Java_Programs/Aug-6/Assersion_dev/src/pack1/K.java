package pack1;
class  K
{
	public static void main(String[] args) 
	{
		int assert =10; 
		System.out.println(assert);
	}
}
//before 1.4 assert is used as identifier and was compiling ssucessfully before 1.4 
/*
F:\Aug-6\Assersion_dev\src>javac -d ../classes -source 1.3 pack1/K.java
warning: [options] bootstrap class path not set in conjunction with -source 1.3
warning: [options] source value 1.3 is obsolete and will be removed in a future release
warning: [options] target value 1.4 is obsolete and will be removed in a future release
warning: [options] To suppress warnings about obsolete options, use -Xlint:-options.
pack1\K.java:6: warning: as of release 1.4, 'assert' is a keyword, and may not be used as an identifier
                int assert =10;
                    ^
  (use -source 1.4 or higher to use 'assert' as a keyword)
pack1\K.java:7: warning: as of release 1.4, 'assert' is a keyword, and may not be used as an identifier
                System.out.println(assert);
                                   ^
  (use -source 1.4 or higher to use 'assert' as a keyword)
6 warnings
F:\Aug-6\Assersion_dev\src>java -cp ../classes -ea pack1.K
10

*/