package team.backup;
//CS 4850: Senior Project, Section 2
//Fall 2015
//Group 3: FileDeposit
//Members: Patrick Warren, Edward Calderon, Michael Bias, William Bennett, Constantino Spanoudakis
//File: Backup.java


import java.io.*;
public class Backup {
	public void BackupFile() throws IOException{
		File source = new File("" + "(copy)");
		if (!source.exists()){
			source.createNewFile();
		}
		FileOutputStream os = new FileOutputStream(source, false);
		os.close();
	}
}

