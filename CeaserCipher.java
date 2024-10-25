package com.projects.level2_projects.encryption;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class CeaserCipher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int shift = 5;
		
		String filePath = "src/com/projects/level2_projects/encryption/text_file.txt";
		String WriteFilePath = "src/com/projects/level2_projects/encryption/text_file_write2.txt";
		
		BufferedWriter writer = new BufferedWriter (new FileWriter(WriteFilePath));
		
		try (BufferedReader reader = new BufferedReader (new FileReader(filePath)))
		{
			String content;
			while((content = reader.readLine())!=null){
				//System.out.println("org string is"+content);
				
				String str = encrypt(content,shift)+"\n";
				writer.write(str);
				
			}
		}
		catch(IOException e)
		{
			 e.printStackTrace(); 
		}
		
		
		
		
		
		/*
		
		//Path pathFileToRead = Paths.get("src/com/projects/level2_projects/encryption/text_file.txt");

		//List<String> lines= Files.readAllLines(pathFileToRead);
		
		ArrayList<String> linesToWrite = new ArrayList<String>();
		
		int shift = 5;
		String str;
		
		for(String msg:lines)
		{
			 str = encrypt(msg,shift);
			 linesToWrite.add(str);
			
		}
		
		
		//Scanner sc = new Scanner(System.in);

		Path pathFileToWrite = Paths.get("src/com/projects/level2_projects/encryption/text_file_write2.txt");
		Files.write(pathFileToWrite, linesToWrite);
		*/
		
		
		writer.close();

		
		
	}

	private static String encrypt(String msg, int shift) {
		// TODO Auto-generated method stub
		
		StringBuilder new_str = new StringBuilder();
		if(msg==null)
			return "end of file";
		msg = msg.toLowerCase();
		
		for(int i=0;i<msg.length();i++)
		{
			
			char c = msg.charAt(i);
			if(Character.isLetter(c))
				c = (char)((c - 'a' + shift +26)%26+'a');
			new_str.append(c);
		}
		
		return new_str.toString();
	}

}
