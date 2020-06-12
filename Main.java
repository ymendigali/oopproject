package mainpackage;

import java.util.Arrays;


import mainpackage.Print;
import mainpackage.Add;
import mainpackage.Search;
import mainpackage.Change;
import mainpackage.Delete;

import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
	public static void main(String[] args) throws IOException {
		

		int exit = 0;
		int answer;

		String currentLine1;
		String f1 = "";//I initialize the variablesto avoid errors
		String f2 = "";
		String f5 = "";
		String f6 = "";
		String f8 = "";
		int f3 = -1;
		int f4 = -1;
		int f7 = -1;
		int f9 = -1;
		String str;
		System.out.println("Give Name: ");
		f1 = input.nextLine();
		System.out.println("Give Surname: ");
		f2 = input.nextLine();
		do {//this is a do-while loop in which I check for valid input (must me integer) and i loop through the txt file again to check if input is duplicate
			duplicate = false;
			valid = true;
			System.out.println("Give Phone: ");
			//f3 = input.nextInt();
			try {
				f3 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				valid = false;
				System.out.println("Phone must be number.");
				//e.printStackTrace();
			}
			while((currentLine1 = reader1.readLine()) != null) {//check for duplicate
				String[] words1=currentLine1.split(",");
				if(words1[2].equals(String.valueOf(f3))) {
					duplicate=true;
					System.out.println("Phone must be unique among the contacts.");
				}
			}
			reader1 = new BufferedReader(new FileReader(file1));
		}while (duplicate == true || valid == false);

		do {
			duplicate = false;
			valid = true;
			System.out.println("Give Mobile phone: ");
			//f4 = input.nextInt();
			try {
				f4 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println("Mobile phone must be number.");
				valid = false;
			}
			while((currentLine1 = reader1.readLine()) != null) {//check for duplicate
				String[] words1=currentLine1.split(",");
				if(words1[3].equals(String.valueOf(f4))) {
					duplicate=true;
					System.out.println("Mobile Phone must be unique among the contacts.");
				}
			}
			reader1 = new BufferedReader(new FileReader(file1));
		}while (duplicate == true || valid == false);
		do {
			duplicate = false;
			System.out.println("Give E-mail: ");
			f5 = input.nextLine();
			while((currentLine1 = reader1.readLine()) != null) {//check for duplicate
				String[] words1=currentLine1.split(",");
				if(words1[4].equals(f5)) {
					duplicate=true;
					System.out.println("E-mail must be unique among the contacts.");
				}
			}
			reader1 = new BufferedReader(new FileReader(file1));
		}while (duplicate == true);
		System.out.println("Give Street: ");
		f6 = input.nextLine();
		System.out.println("Give street number: ");
		//f7 = input.nextInt();
		do {
			valid = true;
			try {
				f7 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println("Street number must be a number.");
				valid = false;
			}
		}while(valid == false);
		System.out.println("Give town: ");
		f8 = input.nextLine();
		System.out.println("Give Zip code: ");
		//f9 = input.nextInt();
		do {
			valid = true;
			try {
				f9 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println("Zip code must be a number.");
				valid = false;
			}
		}while(valid == false);
		if(f1 == "" || f2 == "" || f5 == "" || f6 == "" || f8 == "" || f3 == -1 || f4 == -1 || f7 == -1 || f9 == -1) {//i check that all variables have a valid attribute assigned
			System.out.println("You gave false inputs, adding new contact wasn't successful: ");
		}
		else {//if everything is correct i build a string
			str = f1 + "," + f2 + "," + String.valueOf(f3) + "," + String.valueOf(f4) + "," + f5 + "," + f6 + "," + String.valueOf(f7) + "," + f8 + "," + String.valueOf(f9);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));//with these code I add a line at the bottom of the file
			out.println(str);
			out.close();
		}
		//input.close();
		//writer1.close();
		writer.close();
		reader1.close();
	}

		public static void name_search() throws IOException, FileNotFoundException{
			String f1,f2;
			System.out.println("Give Name: ");
			f1 = input.nextLine();
			System.out.println("Give Surname: ");
			f2 = input.nextLine();
			File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine;
			boolean first = false;
			String[] fields = new String[0];
			List<String> lines = new ArrayList<String>();
			while((currentLine = reader.readLine()) !=null) {
				if(!first) {
					fields = currentLine.split(",");
					first = true;
				}
				else {// only if both of the user's inputs (name and surname) match a contact then i add this contact's info to an array
					String[] info=currentLine.split(",");
					if(info[0].equals(f1) && info[1].equals(f2)) {
						System.out.println("----There is a contact for the information you gave----");
						for (int i = 0; i < fields.length; i++ ) {
							System.out.println(fields[i] +": "+ info[i]);
						}
						//contact_change(currentLine);
						lines.add(currentLine);
					}
					else if(info[0].equals(f1) && !info[1].equals(f2)) {
						System.out.println("----There is a contact for the Name you gave----");
						for (int i = 0; i < fields.length; i++ ) {
							System.out.println(fields[i] +": "+ info[i]);
						}
						System.out.println("----Name ans Surname must be valid----");
					}
					else if(!info[0].equals(f1) && info[1].equals(f2)) {
						System.out.println("----There is a contact for the Surname you gave----");
						for (int i = 0; i < fields.length; i++ ) {
							System.out.println(fields[i] +": "+ info[i]);
						}
						System.out.println("----Name and Surname must be valid----");
					}

				}
			}
			System.out.println("-------------------");
			reader.close();
			for(Object str:lines){//for every contatc that i found that is a match
				contact_delete(str.toString());
			}
			choose_field();
		}

		public static void number_search() throws IOException, FileNotFoundException{
			int f1 = -1;
			int f2 = -1;
			boolean valid;
			System.out.println("Give Phone number: ");
			do {
				valid = true;
				try {
					f1 = Integer.parseInt(input.nextLine());
				} catch (NumberFormatException e) {
					//e.printStackTrace();
					valid = false;
				}
			}while(valid == false);
			System.out.println("Give Mobile number: ");
			do {
				valid = true;
				try {
					f2 = Integer.parseInt(input.nextLine());
				} catch (NumberFormatException e) {
					//e.printStackTrace();
					valid = false;
				}
			}while(valid == false);
			File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine;
			boolean first = false;
			String[] fields = new String[0];
			if(f1 == -1 && f2 == -1) {
				System.out.println("-------------------");
				System.out.println("You gave wrong information.");
			}
			else {
				while((currentLine = reader.readLine()) !=null) {
					if(!first) {
						fields = currentLine.split(",");
						first = true;
					}
					else {
						String[] info=currentLine.split(",");
						if(f1 == -1 && f2 != -1) {
							if(info[3].equals(String.valueOf(f2))) {
								System.out.println("----There is a contact for the Mobile number you gave----");
								for (int i = 0; i < fields.length; i++ ) {
									System.out.println(fields[i] +": "+ info[i]);
								}
								System.out.println("----Phone and Mobile numbers must be valid----");
							}
						}
						else if(f1 != -1 && f2 == -1) {
							if(info[2].equals(String.valueOf(f1))) {
								System.out.println("----There is a contact for the Phone number you gave----");
								for (int i = 0; i < fields.length; i++ ) {
									System.out.println(fields[i] +": "+ info[i]);
								}
								System.out.println("----Phone and Mobile numbers must be valid----");
							}
						}
						else if (f1 != -1 && f2 != -1) {
							if(info[2].equals(String.valueOf(f1)) && info[3].equals(String.valueOf(f2))) {
								System.out.println("----There is a contact for the information you gave----");
								for (int i = 0; i < fields.length; i++ ) {
									System.out.println(fields[i] +": "+ info[i]);
								}
								contact_delete(currentLine);
							}
							else if(info[2].equals(String.valueOf(f1)) && !info[3].equals(String.valueOf(f2))) {
								System.out.println("----There is a contact for the Phone number you gave----");
								for (int i = 0; i < fields.length; i++ ) {
									System.out.println(fields[i] +": "+ info[i]);
								}
								System.out.println("----Phone and Mobile numbers must be valid----");
							}
							else if(!info[2].equals(String.valueOf(f1)) && info[3].equals(String.valueOf(f2))) {
								System.out.println("----There is a contact for the Mobile number you gave----");
								for (int i = 0; i < fields.length; i++ ) {
									System.out.println(fields[i] +": "+ info[i]);
								}
								System.out.println("----Phone and Mobile numbers must be valid----");
							}
						}
					}
				}
			}

			System.out.println("-------------------");
			reader.close();
			choose_field();
		}
		//we will loop until user wants to exit the application
		do {
			System.out.println("Do you want to print contacts, add contact, search for contact, edit contact or delete contact?");
			System.out.println("Answer with '1', '2', '3', '4', '5' or '0' to exit application.");	
			try {//we handle the input of the user
				answer = input.nextInt();
			} catch (NumberFormatException e) {
			    //e.printStackTrace();
				answer = -1;
			}
			if(answer == 1)//according to user's input we go to each class
				Print.show_contacts();
			else if(answer == 2)
				Add.add_contact();
			else if(answer == 3)
				Search.choose_field();
			else if(answer == 4)
				Change.choose_field();
			else if(answer == 5)
				Delete.choose_field();
				
			
		}while(answer != exit);
		System.out.println("Application terminating...");
	}
}
