package com.example.filemaster;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
public class MainActivity extends Activity{
  ListView list;
//  TextView textview;
  private Spinner spinner;
  ArrayAdapter<String> listadapter;
  ArrayList<String> listdata = new ArrayList<String>();
  String[] web = 
		  {
		       "Documents",
		  	   "Downloads",
			   "Media ",
			   "Media "
			   };
  Integer[] imageId = {
      R.drawable.folder4,
      R.drawable.folder4,
      R.drawable.floppy,
      R.drawable.floppy,
     
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  
    setContentView(R.layout.main);
    //Json Parsing it will easy.
    CustomList adapter = new
        CustomList(MainActivity.this, web, imageId);
    list=(ListView)findViewById(R.id.list);
   // textview=(TextView)findViewById(R.id.txt);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                   // Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent("com.example.filemaster.SecondActivity");
                    //startActivity(i);
                	String item = (String) parent.getItemAtPosition(position);
                	//Log.i("Postion ID", item);
                	
                	 Toast.makeText(getApplicationContext(),item,Toast.LENGTH_LONG).show();  
                	Intent i;
                	switch (position) {
					case 0:
						Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
	                     
                    	  i = new Intent("com.example.filemaster.FirstActivity");
                         startActivity(i);
						break;
						
						
						
					case 1:
	                     	Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
	                     
	                     	  i = new Intent("com.example.filemaster.SecondActivity");
	                     	
	                     	  startActivity(i);
	                     	 break;
	                     
                	case 2:
	                    	//Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
	                    
	                    	 i = new Intent("com.example.filemaster.ThirdActivity");
	                    	 startActivity(i);
	                    	 break;
	                    	
                	case 3:
	                         	//Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
	                         
	                    		 i = new Intent("com.example.filemaster.FourActivity");
	                    		 startActivity(i);
	                    		 break;
	                    		
	                      
						
					}
                	
                
                }
            });
  }
  
//Menu Code BeginsFront Page
  
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	MenuInflater menuInflater = getMenuInflater();
	menuInflater.inflate(R.menu.popup, menu);
	return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onMenuItemSelected(int featureId, MenuItem item) {
	// TODO Auto-generated method stub
	
switch (item.getItemId()) {  
	

    case R.id.mount:  
        Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();  
      return true;     
      
  
    case R.id.filesystem:  
        Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();  
      return true;     
      
    case R.id.about:  
        Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();  
      return true;  
      
    case R.id.help:  
        Toast.makeText(getApplicationContext(),"Item 4 Selected",Toast.LENGTH_LONG).show();  
      return true;     

      case R.id.settings:  
          Toast.makeText(getApplicationContext(),"Item 5 Selected",Toast.LENGTH_LONG).show();  
        return true; 
      
      default:  
        return super.onOptionsItemSelected(item); 

		}


	}
  
  
}
