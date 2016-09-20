package lab11;

import java.io.File;
import java.util.ArrayList;

public class Cp2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rootDirectory = ".";
		System.out.println(findFiles(new File(rootDirectory)));

	}

	public static ArrayList<String> findFiles(File f) {
		ArrayList<String> fileNames = new ArrayList<String>();
		return helper(fileNames, f);
		
	}
	
	public static ArrayList<String> helper(ArrayList<String> fileNames, File f){
		if(!f.isDirectory() && f.getName().contains(".java")){
			fileNames.add(f.getName());
		} else if(f.isDirectory()){
			File[] fs = f.listFiles();
			for(File file : fs){
				helper(fileNames, file);
			}
		}
		return fileNames;
	}
}
