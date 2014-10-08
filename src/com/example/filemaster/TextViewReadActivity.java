package com.example.filemaster;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TextViewReadActivity extends Activity {
	TextView readTextview;
	 String  nameReceived ;
	 String pathdir;
	 String data;
	 String filename;
	 


	protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readandwrite);
 
        // 1. get passed intent
       // Intent intent = getIntent();
 
        // 2. get message value from intent
        readTextview=(TextView)findViewById(R.id.readtextview);
     
        nameReceived = getIntent().getExtras().getString("message");
        pathdir=getIntent().getExtras().getString("path");
        filename=getIntent().getExtras().getString("message");
        Log.d("File Name", nameReceived);
        Log.d("File Directory",pathdir);
        Log.d("File ",filename);
        FileOperations fop = new FileOperations();
	      String text = fop.read(nameReceived);
	      String foldertext=fop.readfolder(pathdir, nameReceived);
	      
	      Log.d("LOG FILE", text);
	   //   Log.d("LOG FILE", foldertext);
	    //Folder within text
	     // String folderText=fop.readfolder(pathdir,nameReceived);
	    //  Log.d("Folder Text", folderText);
	      if(text != null){
	    	  readTextview.setText(text);
	      }
	      
	      else  if (foldertext !=null) {
	    	  readTextview.setText(foldertext);
		}
	      else {
	        Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
	      
	      } 
	     
	   
	}
        
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
			

			MenuInflater menuInflater = getMenuInflater();
			menuInflater.inflate(R.menu.readtextfile, menu);//Menu Resource, Menu  
		    return true;

			}


		@SuppressLint("NewApi")
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			switch (item.getItemId()) {  
			

		    case R.id.edit:  
		      
		    	
		    	Intent i = new Intent(TextViewReadActivity.this, EditReadWrite.class);
		    	data=getIntent().getExtras().getString("message");
		    	Log.d("ITem info", data);
		    	i.putExtra("new", data);
		    	startActivity(i);
		    	Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show(); 
		        
		    	
		        
		        //.newInstance().show(getChildFragmentManager(), null);
		        
		        //--------------
		      return true;     
		      
		  
		    case R.id.fontSize:  
		        Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();  
		   
		      return true;     
		      
		    case R.id.color:  
		        Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();  
		      return true;  
		      
		   
		      default:  
		        return super.onOptionsItemSelected(item);  
				}  
			}

		private AlertDialog createDialogBox() {
			// TODO Auto-generated method stub
			return null;
			
			
		}

		}