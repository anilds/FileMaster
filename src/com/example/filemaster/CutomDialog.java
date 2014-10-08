package com.example.filemaster;



import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView.FindListener;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class CutomDialog extends DialogFragment{
	Context context;
	
	public static CutomDialog newInstance(){
		CutomDialog f = new CutomDialog();
	    return f;
	  }

	@SuppressLint("NewApi")
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
	   // View promptsView = li.inflate(R.layout.alert_dialog_newfolder, null);
 
	    LayoutInflater inflater = getActivity().getLayoutInflater();
	    
	    alert.setTitle("Create Folder");
        alert.setMessage("Enter a name for the new folder");
       // alert.getWindow().setLayout(600, 400); //Controlling width and height.
       // alert.show(); 
        
       
       // alert.setIcon(R.drawable.ic_home);

        // Set an EditText view to get user input 
      //  final Button img=(Button)findViewById(R.id.imageButton1);
       // final EditText input = new EditText(getActivity());
       // input.setCompoundDrawables(null, null, getResources().getDrawable(R.drawable.ic_action_collection), null);
      /*  input.setHeight(100);
        input.setWidth(340);
        input.setGravity(Gravity.LEFT);

        input.setImeOptions(EditorInfo.IME_ACTION_DONE);
        alert.setView(input);*/

        alert.setView(inflater.inflate(R.layout.alert_dialog_newfolder, null))
	      .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        @Override
	        public void onClick(DialogInterface dialog, int id) {
	           //TODO
	        	
	        	//Editable value = input.getText();
		          // Do something with value!
	        	Dialog d = (Dialog) dialog;   
		        //input.setText( input.getText() + " " + img.getText() );
	        	EditText x = (EditText)d.findViewById(R.id.editText2);
		        String str = x.getText().toString();
		        Log.i("FourActivity", str);
		        Toast msg = Toast.makeText(getActivity(),str,
		    	  	    Toast.LENGTH_LONG);
		    	  	    msg.show();
		    	  	   
	        }
	      });
	    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int id) {
	        	CutomDialog.this.getDialog().cancel();
	        }
	      });  
	    return alert.create();
	  }    
	}