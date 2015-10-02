//CS 4850: Senior Project, Section 2
//Fall 2015
//Group 3: FileDeposit
//Members: Patrick Warren, Edward Calderon, Michael Bias, William Bennett, Constantino Spanoudakis
//File: BackupMain.java

import java.io.*; //This is used to get all the imports associated with file management

public class BackupMain {
	public static void main(String[]args){
		InputStream iStream = null;
		OutputStream oStream = null;
		try{
			File a = new File("src/A.txt");
			File b = new File("src/B.txt");
			
			iStream = new FileInputStream(a);
			oStream = new FileOutputStream(b);
			
			byte[] buffer = new byte[1024];
			
			int length;
			//copying the file content in bytes
			while ((length = iStream.read(buffer)) > 0){
				oStream.write(buffer,  0,  length);
			}
			iStream.close();
			oStream.close();
			
			System.out.println("File successfully copied!");
		}catch(IOException e){
			e.printStackTrace();
		}
		/*String greeting = new String("Hello! Welcome to FileDeposit!");
		System.out.println(greeting);*/
	}
	
}
