//CS 4850: Senior Project, Section 2
//Fall 2015
//Group 3: FileDeposit
//Members: Patrick Warren, Edward Calderon, Michael Bias, William Bennett, Constantino Spanoudakis
//File: Backup.java

import java.io.*;

public class Backup {
	private static void copyFile(File source, File target) throws IOException{
		InputStream is = null;
		OutputStream os = null;
		try{
			is = new FileInputStream(source);
			os = new FileOutputStream(target);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0){
				os.write(buffer, 0, length);
			}
		}finally{
			is.close();
			os.close();
		}
	}
	public static void main(String[] args) throws IOException{
		File source = new File("/Users/Patrick/tmp/source.docx");
		File target = new File("/Users/Patrick/tmp/target.docx");
		
		copyFile(source, target);
		System.out.println("File successfully copied. Thank you for using FileDeposit.");
	}
}

