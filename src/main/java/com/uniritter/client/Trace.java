package com.uniritter.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Trace {

	private long count = 0;
	private static String locationOutput = "C:\\TEMP\\";
	private static String locationInput = "C:\\TEMP_INPUT\\";
	
	public void writeArchive(String valor) throws Throwable {
		count++;
		File file = new File(locationOutput+"Alert" + count + ".txt");

		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(valor);
		writer.flush();
		writer.close();
	}

	public String readArchive() throws Throwable {

		String acc = "";
		File file = new File(locationInput+"Parameters.txt");
		if(file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			String sCurrentLine = "";
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				acc = sCurrentLine;
				break;
			}
			br.close();
			file.delete();
	
		}
		return acc;
	}

	public void writeFile(Throwable t) {
		count++;
		try{
			File file = new File(locationOutput+"AlertErro" + count + ".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(t.getMessage());
			writer.flush();
			writer.close();
			File fileFrom = new File(locationInput+"Parameters.txt");
			fileFrom.delete();
		}catch(Throwable e){
			System.out.println(e);
		}
		
	}
	

}