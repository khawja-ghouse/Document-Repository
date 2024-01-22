import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class M9 
{
	public static void main(String[] args) 
	{
		File src = new File("C:\\Users\\My PC\\Desktop\\nadeem.jpg");
		File target = new File("sabiha.jpg");
		try(//taking the image input 
			FileInputStream fin = new FileInputStream(src);
			BufferedInputStream bin = new BufferedInputStream(fin);
			//creating the new image through existing one 
			FileOutputStream fout = new FileOutputStream(target);
			BufferedOutputStream bout = new BufferedOutputStream(fout))
		{
			byte[] bytes = new byte[(int) src.length()];
			bin.read(bytes);
			bout.write(bytes);
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}

}
