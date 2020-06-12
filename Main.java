package mainpackage;

import java.util.Arrays;
import java.util.Scanner;

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
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		int exit = 0;
		int answer;
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
	public static void read_txt(){
		File file1 = new File(System.getProperty("user.dir")+"/src/contacts.txt");// we get the file
		BufferedReader reader1 = new BufferedReader(new FileReader(file1)); // we get reader for the file
		OutputStreamWriter writer1 = new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.dir")+"/src/contacts.txt", true), "UTF-8");
		BufferedWriter writer = new BufferedWriter(writer1);//this is a way to get a writer for th specific file
		Scanner input= new Scanner(System.in);
	
	}
}
