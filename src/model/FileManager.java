package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileManager {
	public FileManager(){
		
	}
	public StringBuilder readFiles() {
		StringBuilder result = new StringBuilder();
		File file1 = new File("C:/Users/I318683/Desktop/abcd.txt");
		try(FileInputStream fis = new FileInputStream(file1)){
			int content;
			while((content = fis.read()) != -1){
				result.append((char)content);
			}
		} catch (IOException e){
			
		}
		return result;
		
	}
	

}
