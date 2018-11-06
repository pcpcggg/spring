package kr.or.ddit.file.util;

public class FileUtil {
	
	//FileUtil.getFileExt(String fileName);
	// 확장자가 있을경우 .을 포함한 확장자  값을 리턴
	// 확장자가 없을경우 "" whitespace를 리턴
	
	public static String getFileExt(String fileName) {
		
		String orgFileName = fileName;
		
		int idx = orgFileName.lastIndexOf(".");
		
		String fileExt = "";
		
		if(idx != -1) {
			fileExt = orgFileName.substring(idx);
		}else {
			fileExt = "";
		}
		
		return fileExt;
	}
	
}
