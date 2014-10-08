package com.example.filemaster;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomList extends ArrayAdapter<String>{
private final Activity context;
private final String[] web;
private final Integer[] imageId;
public CustomList(Activity context,String[] web, Integer[] imageId) {
super(context, R.layout.list_row_activity, web);
this.context = context;
this.web = web;
this.imageId = imageId;
}


TextView internaltotalspace;
TextView internalavailablespace;
TextView externaltotalspace;
TextView externalavailablespace;
@Override
public View getView(int position, View view, ViewGroup parent) {
LayoutInflater inflater = context.getLayoutInflater();
View rowView= inflater.inflate(R.layout.list_row_activity, null, true);
TextView txtTitle = (TextView) rowView.findViewById(R.id.title);
TextView textview=(TextView)rowView.findViewById(R.id.internal);
TextView textview1=(TextView)rowView.findViewById(R.id.external);
ImageView imageView = (ImageView) rowView.findViewById(R.id.thumbnail);
txtTitle.setText(web[position]);
internaltotalspace=(TextView)rowView.findViewById(R.id.internaltotalspace);
internalavailablespace=(TextView)rowView.findViewById(R.id.internalavailablespace);
externaltotalspace=(TextView)rowView.findViewById(R.id.externaltotalspace);
externalavailablespace=(TextView)rowView.findViewById(R.id.externalavailablespace);
//Context context = null ;

if (position==2){
	 internalStorageLabel();
	 internalAvailableLabel();
	// File internal_path=getDir(Environment.DIRECTORY_DOWNLOADS, 0);	
	
	try{
		
		textview.setText("/storage/sdcard1");
		
       }catch(Exception e){
      	 Log.i("Tag", "Internal  Information Control");
       }
}else

if (position==3){
	externalStorageLabel();
	externalAvailableLabel();
	try{
  	  File sdCardRoot = Environment.getExternalStorageDirectory();
	  String sdPath = sdCardRoot.toString();
	       
	  	textview1.setText(sdPath);
	      // Toast.makeText(this,"SD Card Path "+PATH,Toast.LENGTH_SHORT).show();
	      
       }catch(Exception e){
      	 Log.i("Tag", "Sd Card Information Control");
       }
}
imageView.setImageResource(imageId[position]);
return rowView;
}




private void internalStorageLabel() {
	long total, aval;
	int kb = 1024;
	long gb = 1024*1024*1024;
	long mb = 1024*1024;
	
	
	StatFs fs = new StatFs(Environment.
							getDataDirectory().getPath());
	
	total = fs.getBlockCount() * (fs.getBlockSize() / kb);
	//aval = fs.getAvailableBlocks() * (fs.getBlockSize() / kb);
	if(total >kb){
		internalavailablespace.setText(String.format("Total: %.2f GB " , (double)total / (kb*kb)));
	}
	else if (total>kb){
		internalavailablespace.setText(String.format("Total: %.2f MB " , (double)total / (kb )));
	}
	else {
		internalavailablespace.setText(String.format("Total: %.2f KB " , (double)total ));
	}
	
	}
private void internalAvailableLabel() {
	// TODO Auto-generated method stub
	long total, aval;
	int kb = 1024;
	long gb = 1024*1024*1024;
	long mb = 1024*1024;
	
	
	StatFs fs = new StatFs(Environment.
							getDataDirectory().getPath());
	
	//total = fs.getBlockCount() * (fs.getBlockSize() / kb);
	aval = fs.getAvailableBlocks() * (fs.getBlockSize() / kb);
	if(aval >mb){
	internaltotalspace.setText(String.format("Available : %.2f GB " , (double)aval / (mb)));
	}
	else if (aval>kb){
	internaltotalspace.setText(String.format("Available: %.2f MB " , (double)aval / (kb )));
	}
	else {
		internaltotalspace.setText(String.format("Available: %.2f KB " , (double)aval ));
	}
	
}

private void externalStorageLabel() {
	long total, aval;
	int kb = 1024;
	
	StatFs fs = new StatFs(Environment.
							getExternalStorageDirectory().getPath());
	
	total = fs.getBlockCount() * (fs.getBlockSize() / kb);
	//aval = fs.getAvailableBlocks() * (fs.getBlockSize() / kb);
		if(total >kb){
			externalavailablespace.setText(String.format("Total: %.2f GB " , (double)total / (kb*kb)));
		}
		else if (total>kb){
			externalavailablespace.setText(String.format("Total: %.2f MB " , (double)total / (kb )));
		}
		else {
			externalavailablespace.setText(String.format("Total: %.2f KB " , (double)total ));
		}
}

private void externalAvailableLabel() {
	// TODO Auto-generated method stub
	
	long total, aval;
	int kb = 1024;
	long gb = 1024*1024*1024;
	long mb = 1024*1024;
	
	
	StatFs fs = new StatFs(Environment.
			getExternalStorageDirectory().getPath());


	
	//total = fs.getBlockCount() * (fs.getBlockSize() / kb);
	aval = fs.getAvailableBlocks() * (fs.getBlockSize() / kb);
	if(aval >mb){
		externaltotalspace.setText(String.format("Available : %.2f GB " , (double)aval / (mb)));
	}
	else if (aval>kb){
		externaltotalspace.setText(String.format("Available: %.2f MB " , (double)aval / (kb )));
	}
	else {
		externaltotalspace.setText(String.format("Available: %.2f KB " , (double)aval ));
	}
	
}

}