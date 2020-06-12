package mainpackage;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mainpackage.Main;

package mainpackage;

public class Delete {
	public static void choose_field() throws FileNotFoundException, IOException {
		int exit = 0;
		int answer;
		//we will loop until user wants to exit the application
		do {//according to user's input i go to the correct method
			System.out.println("Do you want to delete a contact based on the name or the phone number?");
			System.out.println("Give '1', '2' or '0' to go back to main menu.");	
			try {
				answer = input.nextInt();
			} catch (Exception e) {
				answer = 0;
			}
			if(answer == 1) 
				name_search();				
			else if(answer == 2)
				number_search();
							
		}while(answer != exit);
	}

	public static void contact_delete(String line)  throws IOException, FileNotFoundException{
		File file1 = new File(System.getProperty("user.dir")+"/src/contacts.txt");
		BufferedReader reader1 = new BufferedReader(new FileReader(file1));	
		String currentLine1;
		boolean first = false;
		String[] fields = new String[0];
		File file2 = new File(System.getProperty("user.dir")+"/src/contactstemp.txt");//i create a temporary file to save the changes
		BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
		while((currentLine1 = reader1.readLine()) !=null) {
			if(!first) {
				fields = currentLine1.split(",");
				writer.write(currentLine1 + "\n");
				first = true;
			}
			else if(!currentLine1.equals(line)){//if the current line in the reader is not the one we want to delete we write it to the temp file	
				writer.write(currentLine1 + "\n");
			}
		}
		reader1.close();
		writer.close();
		file1.delete();//we delete the original file
		file2.renameTo(file1);//we rename the temporary file to the original file's name
		System.out.println("Information was valid, deletion completed successfully");
	}
}
