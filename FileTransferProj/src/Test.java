import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
			
		if(getSkippedUrls().contains("register1.do")){
			System.out.println("in if..");
		}else{
			System.out.println("in else..");
		}
		
	}
	
	
	private static List<String> getSkippedUrls(){
		List<String> skippedUrlList = new ArrayList<String>();
		skippedUrlList.add("login.do");
		skippedUrlList.add("register.do");
		skippedUrlList.add("forgotpwd.do");
		skippedUrlList.add("error500.do");
		skippedUrlList.add("downloadSamples.do");
		return skippedUrlList;
	}

}
