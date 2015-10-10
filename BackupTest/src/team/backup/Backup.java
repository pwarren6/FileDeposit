package team.backup;
//CS 4850: Senior Project, Section 2
//Fall 2015
//Group 3: FileDeposit
//Members: Patrick Warren, Edward Calderon, Michael Bias, William Bennett, Constantino Spanoudakis
//File: Backup.java


import java.io.*;
import java.nio.channels.FileChannel;
public class Backup {
	@SuppressWarnings("resource")
	public static void BackupFile(File source, File target) throws IOException{
		FileChannel input = null;
		FileChannel output = null;
		try{
			input = new FileInputStream(source).getChannel();
			output = new FileOutputStream(target).getChannel();
			output.transferFrom(input, 0, input.size());
		}finally{
			input.close();
			output.close();
		}
	}
	public static void main(String[] args) throws IOException{
		File source = new File("C:/Users/Patrick/Documents/traingate.png");
		File target = new File(source.getAbsolutePath() + "(copy)");
		if(!target.exists()){
			target.createNewFile();
		}
		BackupFile(source, target);
		Runtime.getRuntime().exec("explorer.exe /select, C:/Users/Patrick/");
	}
}


