package com.example.filemaster;

import java.lang.reflect.Method;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//---get the data passed in using getStringExtra()---
		TextView tv=(TextView)findViewById(R.id.textView1);
		Toast.makeText(this,"second activity ",Toast.LENGTH_SHORT).show();
		
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
    	 FragmentManager manager = getFragmentManager(); // or getFragmentManager, depends on which api lvl you are working on but supportFragmentManager will make you dialog work also on devices lower than api lvl 11(3.0 - > Honeycomb)
	       DialogFragment Dialog = CutomDialog.newInstance();
	        Dialog.show(manager, "tag"); 
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