package util;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.TimerTask;

public abstract class Schedule extends TimerTask{	
	public final static int REPLACE = 1;
	public final static int VERSION_CONTROL = 2;
	
	public abstract void setName(String name);
	public abstract String getName();
	public abstract File getOutputFolder();
	public abstract void setOutputFolder(File outputFolder);
	public abstract List<File> getFiles();
	public abstract File getFile(int index);
	public abstract void addFile(File file);
	public abstract void removeFile(File file);
	public abstract void setFirstTime(Date firstTime);
	public abstract Date getFirstTime();
	public abstract void setPeriod(long period);
	public abstract Long getPeriod();
	public abstract void enable();
	public abstract void disable();
	public abstract int getType();
	public abstract void setType(int type);
	public abstract boolean isEnabled();
	public abstract UUID getScheduleId();
	public abstract void run();
	
}

