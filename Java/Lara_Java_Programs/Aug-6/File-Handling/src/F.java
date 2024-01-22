import java.io.Serializable;

public class F implements Serializable
{
	//public static final long serialVersionUID = 1000;
	 int i;
	 int j;
	 
}
//while compiling seri version id also will be created by the compiler
//while  serialization and deserialization id should be same while  compiling then only compiling will be success otherwise it will throw error

//if you are creating the serial version  id by yourself in every modification we have to change that serial id may be we are forgetting that one so
//it is not advisable to  create ourself 
//we can see the serial version id in ourself that is serialVer F
