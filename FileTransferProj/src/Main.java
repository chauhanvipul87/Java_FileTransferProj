import java.util.Properties;


public class Main {

	public Main(){
		Properties prop = FileUitlity.initializeParameters();
		String deleteFilePath = prop.getProperty("deleteFilePath");
		String copyFilePath   = prop.getProperty("copyFilePath");
		String destFilePath   =  prop.getProperty("destFilePath");
		boolean isDeleted = 	FileUitlity.deleteOldFile(deleteFilePath);
		boolean isCreated = 	FileUitlity.copyProjectFile(copyFilePath,destFilePath);
		
	}
	
	public static void main(String args[]){
		Main m = new Main();
	}
	
	
}
