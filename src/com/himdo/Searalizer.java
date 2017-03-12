package com.himdo;
import java.io.Serializable;
import java.nio.file.Path;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Searalizer implements Serializable{
	static public void save(Object object,String string){
	try {
		
		FileOutputStream fos = new FileOutputStream(string);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(object);
		out.flush();
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	static public Object load(String path){
		if(path==null)
			return null;
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fis);
			Object object = in.readObject();
			in.close();
			return object;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
