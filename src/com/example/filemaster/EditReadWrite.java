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


public class EditReadWrite extends Activity {
	//TextView readTextview;
	EditText edittextview;
	 String  nameReceived ;
	 String pathdir;
	// String data;
	 String fileContent;
	 


	protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writetext);
 
        // 1. get passed intent
       // Intent intent = getIntent();
 
        // 2. get message value from intent
        edittextview=(EditText)findViewById(R.id.editwritetext);
     
        nameReceived = getIntent().getExtras().getString("new");
        pathdir=getIntent().getExtras().getString("path");
        Log.d("Edit Text", nameReceived);
        //Log.d("File Directory",pathdir);
        FileOperations fop = new FileOperations();
	      String text = fop.read(nameReceived);
	      
	      Log.d("LOG FILE", text);
	    
	      if(text != null){
	    	  edittextview.setText(text);
	      }
	      else {
	        Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
	       
	       // readTextview.setText(folderText);
	      } 
	      
	     
	}
        
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
			

			MenuInflater menuInflater = getMenuInflater();
			menuInflater.inflate(R.menu.writetext, menu);//Menu Resource, Menu  
		    return true;

			}


		@SuppressLint("NewApi")
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			switch (item.getItemId()) {  
			

		    case R.id.edit:  
		      
		    
		        //.newInstance().show(getChildFragmentManager(), null);
		        
		        //--------------
		      return true;     
		      
		  
		    case R.id.newfile:  
		        Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();  
		   
		      return true;     
		      
		    case R.id.open:  
		        Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();  
		      return true;  
		      
		    case R.id.save:  
		    	
		        nameReceived = getIntent().getExtras().getString("new");
		 	    String filecontent = edittextview.getText().toString();
		 	    Log.d("Save Content", nameReceived);
		 	    Log.d("Save File Content", filecontent);
		 	    FileOperations fop = new FileOperations();
		 	    fop.write(nameReceived, filecontent);
		 	    if(fop.write(nameReceived, filecontent)){
		 	    Toast.makeText(getApplicationContext(), nameReceived + " Saved", Toast.LENGTH_SHORT).show();
		 	    }else{
		 	      Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();
		 	    }
		        
		      return true;  
		    case R.id.details:  
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