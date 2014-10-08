package com.example.filemaster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.util.Log;

public class FileOperations {
	
	public String read(String fname){
	     BufferedReader br = null;
	     String response = null;
	      try {
	        StringBuffer output = new StringBuffer();
	        String fpath = "/sdcard/"+fname;
	        br = new BufferedReader(new FileReader(fpath));
	        String line = "";
	        while ((line = br.readLine()) != null) {
	          output.append(line +"\n");
	        }
	        response = output.toString();
	      } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	      }
	      return response;
	   }
	 public Boolean write(String fname, String fcontent){
	      try {
	        String fpath = "/sdcard/"+fname;
	        File file = new File(fpath);
	        // If file does not exists, then create it
	        if (!file.exists()) {
	          file.createNewFile();
	        }
	        FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(fcontent);
	        bw.close();
	        Log.d("Suceess","Data  edited");
	        return true;
	      } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	      }
	   }

	public String readfolder(String path, String fname) {
		 BufferedReader br = null;
	     String response = null;
	      try {
	        StringBuffer output = new StringBuffer();
	        String fpath = "/sdcard/"+path+"/"+fname;
	        Log.d("readfolder", fpath);
	        br = new BufferedReader(new FileReader(fpath));
	        String line = "";
	        while ((line = br.readLine()) != null) {
	          output.append(line +"\n");
	        }
	        response = output.toString();
	      } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	      }
	      return response;
	   }
  }

