package test.javasandbox.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadWriteText {
	static String inFileText = "TestText.txt";
	static String outFileText = "TestText-Out.txt";

	public static void main(String[] args) {
//		readTextFromFile();
//		readFromConsole();
//		writeTextToFile();
		readWriteText();
	}

	static void readTextFromFile() {
//		if(new File(inFileText).isFile()) {
//			System.out.println("Exists");
//		} else {
//			System.out.println("Not Found");
//		}

		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFileText), "UTF-8"))) {
			StringBuilder text = new StringBuilder();
			String line;
			
			while ((line = in.readLine()) != null) {
				text.append(line).append(System.getProperty("line.separator"));
			}
			
			System.out.println(text.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readFromConsole() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
			System.out.println("Please enter input: ");
			String input = in.readLine();
			System.out.println("Your input: " + input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void writeTextToFile() {
		try (BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(outFileText /* , true //For appending */), "UTF-8"))) {
			out.write("Hello World!");
			System.out.println("Written text to file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readWriteText() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFileText), "UTF-8"));
				BufferedWriter out = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(outFileText), "UTF-8"))) {
			StringBuilder text = new StringBuilder();
			String line;
			
			while ((line = in.readLine()) != null) {
				text.append(line).append(System.getProperty("line.separator"));
			}
			
			String outText = text.toString();
			System.out.println("Read file: ");
			System.out.println(outText);
			out.write(outText);
			System.out.println("Written text to file.");
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
