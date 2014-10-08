package com.example.filemaster;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomFourList extends ArrayAdapter<String>{
private final Activity context;
private final String web;
private List<String> item = null;
private List<String> path = null;
private String root;



public CustomFourList(Activity context,String web) {
super(context, R.layout.list_row_four);
this.context = context;
this.web = web;

}
void getDir(String dirPath)
{
	//myPath.setText("Location: " + dirPath);
	
	Log.d("Info", dirPath);
	
	//imageView=(ImageView)findViewById(R.id.imgfour);
	
	//Log.d("Location", myPath);
	item = new ArrayList<String>();
	path = new ArrayList<String>();
	File f = new File(dirPath);
	File[] files = f.listFiles();
	
	
	
	/*if(!dirPath.equals(root))
	{
		//item.add(root);
		//path.add(root);
		//item.add("../");
		path.add(f.getParent());	
	}*/
	
	for(int i=0; i < files.length; i++)
	{
		File file = files[i];
		String myfiles=file.toString();
		//String[] myfiles=file.toString();
		Log.d("INFO", myfiles);
		
		if(!file.isHidden() && file.canRead()){
			path.add(file.getPath());
    		if(file.isDirectory()){
    			item.add(file.getName() );
    			//imageView.setImageResource(R.drawable.folder);
    		}else{
    			item.add(file.getName());
    		}
		}	
	}
	}
}