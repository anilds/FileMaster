package com.example.filemaster;



import java.io.File;
import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.os.Environment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ThirdActivity extends Activity {
	 
	private static final int REQUEST_PATH = 1;
 
	private String curFileName = "";
	
	private EditText edittext;
	private TextView bTag;
	
	private static int tag = 0;
	

     
    /**********  File Path *************/
    final String uploadFilePath = "/storage/sdcard1"+ "/Tossup/";
    
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
       // setContentView(R.layout.activity_fileexplorer); 
        Log.d("Internal storage", uploadFilePath);
        
        getfile();
        
       
    }
	
    public void getfile(){ 
    	Intent intent1 = new Intent(this, FileChooserInternalStorage.class);
    	ThirdActivity.this.finish();
        startActivityForResult(intent1,REQUEST_PATH);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        // See which child activity is calling us back.
    	if (requestCode == REQUEST_PATH){
    		if (resultCode == RESULT_OK) { 
    			curFileName = data.getStringExtra("GetFileName"); 
    			//edittext.setText(curFileName);    			
    			//tag = buildTag(curFileName);
    			//bTag.setText(Integer.toString(tag));
    			Intent returnIntent = new Intent();
    			returnIntent.putExtra("filename", curFileName);
    			setResult(RESULT_OK,returnIntent);
    			finish();
    			
    			
    		}
    	 }
    }   
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		

		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.activity_menu, menu);//Menu Resource, Menu  
	    return true;

		}


	@SuppressLint("NewApi")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {  
		

	    case R.id.item1:  
	       // Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show(); 
	     
	        FragmentManager manager = getFragmentManager(); // or getFragmentManager, depends on which api lvl you are working on but supportFragmentManager will make you dialog work also on devices lower than api lvl 11(3.0 - > Honeycomb)
	       DialogFragment Dialog = CutomDialog.newInstance();
	        Dialog.show(manager, "tag");
	      
	    	
	        Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show(); 
	        //.newInstance().show(getChildFragmentManager(), null);
	        
	        //--------------
	      return true;     
	      
	  
	    case R.id.item2:  
	        Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();  
	   
	      return true;     
	      
	    case R.id.item3:  
	        Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();  
	      return true;  
	      
	    case R.id.item4:  
	        Toast.makeText(getApplicationContext(),"Item 4 Selected",Toast.LENGTH_LONG).show();  
	      return true;     

	      case R.id.item5:  
	          Toast.makeText(getApplicationContext(),"Item 5 Selected",Toast.LENGTH_LONG).show();  
	        return true; 
	        
	      case R.id.item6:  
	          Toast.makeText(getApplicationContext(),"Item 6 Selected",Toast.LENGTH_LONG).show();  
	        return true; 
	        
	      case R.id.refresh:  
	          Toast.makeText(getApplicationContext(),"Item 7 Selected",Toast.LENGTH_LONG).show();  
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