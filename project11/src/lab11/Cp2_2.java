package lab11;

import java.io.File;

public class Cp2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rootDirectory = ".";

		System.out.println(size(new File(rootDirectory)));
	}
	
	public static long size(File f){
		int size = 0;
		if(!f.isDirectory()){
			return f.length();
		} else{
			File[] fs = f.listFiles(); 
			for(File F : fs){
				size += size(F);
			}
			return size;
		}
	}

}
