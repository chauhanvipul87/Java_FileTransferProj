import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class FileUitlity {

	public static void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    if(!folder.getName().equalsIgnoreCase("webapps"))
	    	folder.delete();
	}
	public static boolean deleteOldFile(String deleteFilePath) {
		try {
			File folder = new File(deleteFilePath);
			deleteFolder(folder);
			System.out.println("File deleted successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static Properties initializeParameters(){
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			System.out.println(prop.getProperty("deleteFilePath"));
			System.out.println(prop.getProperty("copyFilePath"));
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
	
	private static void copyFileUsingStream(File source, File dest) {
		InputStream is = null;
	    OutputStream os = null;
	    try {
		
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    }  catch (IOException ex) {
			ex.printStackTrace();
		}finally {
	        try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	       
	    }
	}
	public static boolean copyProjectFile(String sourcePath, String destPath) {
		System.out.println(sourcePath);
		System.out.println(destPath);
		File source = new File(sourcePath);
        File dest = new File(destPath);
        copyFileUsingStream(source, dest);
        System.out.println("File copied successfully");
		return true;
	}


}
