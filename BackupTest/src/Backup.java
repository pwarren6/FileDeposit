//CS 4850: Senior Project, Section 2
//Fall 2015
//Group 3: FileDeposit
//Members: Patrick Warren, Edward Calderon, Michael Bias, William Bennett, Constantino Spanoudakis
//File: Backup.java


import java.io.IOException;
import java.nio.file.*;
public class Backup {
	public static void main(String args[]) throws IOException{
		System.getenv("windir");
		Path FROM = Paths.get("C:/Users/Patrick/tmp");
		Path TO = Paths.get("C:/Users/Patrick/tmp/");
		CopyOption[] options = new CopyOption[]{
			StandardCopyOption.REPLACE_EXISTING,
			StandardCopyOption.COPY_ATTRIBUTES
		};
		Files.copy(FROM,  TO, options);
		System.out.println(System.getenv("windir"));
	}
}

