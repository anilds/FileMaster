package com.example.filemaster;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FileChooserInternalStorage extends ListActivity {

	private File currentDir;
    private FileArrayAdapter adapter;
    private String ROOT_DIR ="/storage/sdcard1";
    
    private TextView tNullFiles;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        Log.d("Internal Storage ", ROOT_DIR);
        
        tNullFiles = (TextView)findViewById(R.id.TextEmpty);
        currentDir = new File(ROOT_DIR);
        fill(currentDir); 
    }
    public String getExt(String s){
    	String extension = "";
    	int i = s.lastIndexOf('.');
    	if(i > 0){
    		extension = s.substring(i+1);
    	}
    	return extension;
    }
    public String fmtSize(long l){
    	long gb = 1024*1024*1024;
    	long mb = 1024*1024;
    	long kb = 1024;
    	if(l > gb)
    		return (l/gb) + "GB";
    	else if(l > mb)
    		return (l/mb) + "MB";
    	else if(l > kb)
    		return (l/kb) + "KB";
    	else
    		return l + "Bytes";    	
    }
    public Boolean isImage(String f){
    	String ext = getExt(f).toLowerCase();
    	if(ext.equals("jpg")){
    		return true;
    	}
    	else if(ext.equals("jpeg")){
    		return true;
    	}
    	else if(ext.equals("gif")){
    		return true;
    	}
    	else if(ext.equals("png")){
    		return true;
    	}
    	else if(ext.equals("bmp"))
    		return true;
    	else{
    		return false;
    	}
    }
    public Boolean isAudio(String f){
    	String ext = getExt(f).toLowerCase();
    	if(ext.equals("wav")){
    		return true;
    	}
    	else if(ext.equals("mp3")){
    		return true;
    	}
    	else if(ext.equals("ogg")){
    		return true;
    	}
    	else if(ext.equals("wmv")){
    		return true;
    	}
    	else{
    		return false;    	
    	}
    	
    }
    private void fill(File f)
    {
    	File[]dirs = f.listFiles(); 
		 //this.setTitle("Current Dir: "+f.getName());
		 List<Item>dir = new ArrayList<Item>();
		 List<Item>fls = new ArrayList<Item>();
		 
		 try{
			 if(dirs == null){
				 tNullFiles.setVisibility(View.VISIBLE);
			 }
			 
			 
			 for(File ff: dirs)
			 { 				 
				Date lastModDate = new Date(ff.lastModified()); 
				DateFormat formater = DateFormat.getDateTimeInstance();
				String date_modify = formater.format(lastModDate);
				if(ff.isDirectory()){					
					
					File[] fbuf = ff.listFiles(); 
					int buf = 0;
					if(fbuf != null){ 
						buf = fbuf.length;
					} 
					else buf = 0; 
					String num_item = String.valueOf(buf);
					if(buf == 0) num_item = num_item + " item";
					else num_item = num_item + " items";
					
					//String formated = lastModDate.toString();
					dir.add(new Item(ff.getName(),num_item,date_modify,ff.getAbsolutePath(),"folder_icon")); 
				}
				else
				{
					if(isImage(ff.getName())){
						// Set icon for image files
						fls.add(new Item(ff.getName(),fmtSize(ff.length()), date_modify, ff.getAbsolutePath(),"img_icon"));
					}
					else if(getExt(ff.getName()).equals("pdf")){
						fls.add(new Item(ff.getName(),fmtSize(ff.length()), date_modify, ff.getAbsolutePath(),"pdf_icon"));
					}
					else if(getExt(ff.getName()).equals("")){
						// Set icon for null extension files
						fls.add(new Item(ff.getName(),fmtSize(ff.length()), date_modify, ff.getAbsolutePath(),"file_icon"));
					}
					else if(isAudio(ff.getName())){
						// Set icon for audio files
						fls.add(new Item(ff.getName(),fmtSize(ff.length()), date_modify, ff.getAbsolutePath(),"music_icon"));
					}
					else{
						fls.add(new Item(ff.getName(),fmtSize(ff.length()), date_modify, ff.getAbsolutePath(),"file_icon"));
					}
				}
				 
				
			 }
		 }catch(Exception e)
		 {    
			 Log.d("FileChooser",e.getMessage());
		 }
		 Collections.sort(dir);
		 Collections.sort(fls);
		 dir.addAll(fls);
		 //This might cause a problem. (using literal instead of envirionment variable
		 /*
		 if(!f.getName().equalsIgnoreCase(ROOT_DIR))
			 dir.add(0,new Item("","Previous directory","",f.getParent(),"directory_up"));
		 */
		 		
		 adapter = new FileArrayAdapter(FileChooserInternalStorage.this,R.layout.file_view,dir);
		 this.setListAdapter(adapter); 
    }
    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Item o = adapter.getItem(position);
		if(o.getImage().equalsIgnoreCase("folder_icon")||o.getImage().equalsIgnoreCase("directory_up")){
				currentDir = new File(o.getPath());
				fill(currentDir);
		}
		else
		{
			onFileClick(o);
		}
	}
   
    @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
    	if(currentDir.toString().equals(ROOT_DIR)){    		
    		Intent intent = new Intent();            
            setResult(RESULT_CANCELED, intent);
            finish();  		
    	}
    	else{
    		currentDir = new File(currentDir.getParent());
			Log.d("FileBrowser", "New Dir: " + currentDir.toString());			
			fill(currentDir);    		
    	}
		
	}
	
	private void onFileClick(Item o)
    {
    	//Toast.makeText(this, "Folder Clicked: "+ currentDir, Toast.LENGTH_SHORT).show();
		Log.d("FileChooser","Path:" + currentDir.toString() + "/" + o.getName());
    	Intent intent = new Intent();
        intent.putExtra("GetPath",currentDir.toString());
        intent.putExtra("GetFileName",o.getName());
        setResult(RESULT_OK, intent);
        finish();
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
