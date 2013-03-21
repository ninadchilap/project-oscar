package com.iitb.oscar;

import java.io.File;
import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity {


    ArrayList<String> ContentList=null;
    String Path;
	
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState)
{
	 super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	File list=new File("/mnt/extsd/OSCAR/");
	if (list.exists()||new File("/mnt/sdcard/OSCAR/").exists())
	{
			if (list.exists())
			{	
		
				Path="/mnt/extsd/OSCAR/";
		 
			}	
			else
			{
				Path="/mnt/sdcard/OSCAR/";
			}
		   
		    ContentList = getContent(Path);
		    
		    if(!ContentList.isEmpty())
		    {
		      System.out.println("MyContents"+ContentList.toString());
		      displayList(ContentList);
		    }
		    else
		    {
		        Toast msg = Toast.makeText(Main.this,"Folder "+Path+" is empty", Toast.LENGTH_LONG);
		    }
		    
	}
	
	
	else
		{
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setIcon(R.drawable.icon);
    	builder.setTitle("OSCAR animations are not present in the tablet!!!");
    	builder.setMessage(	"Please check whether animations are present at any one of the"+"\n"
    	+"following locations"+"\n"+"\n"+"1. go to mnt/sdcard/OSCAR"
    			+"\n"+"2. go to mnt/extsd/OSCAR")
    	
    	       .setCancelable(false)
    	       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	        	
    	        	   Main.this.finish();
    	        	
    	           }
    	       });
    	AlertDialog alert = builder.create();   
    	alert.show();
	
	
	 
}
   
}


public ArrayList<String> getContent(String DirectoryPath)
{
  ArrayList<String> MyFiles = new ArrayList<String>();
    File f = new File(DirectoryPath);
    File[] files = f.listFiles();
    if (files.length == 0)
        return null;
    else {
        for (int i=0; i<files.length; i++){            
            MyFiles.add(files[i].getName());
          
        }
    }
            return MyFiles;

}

public void displayList(ArrayList<String> Contents)
{

       ListView lv = (ListView) findViewById(R.id.lstCourses); 
        
        if(!Contents.isEmpty())
        {
         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.row,R.id.rowTitle,Contents);

        lv.setAdapter(arrayAdapter);
        
          lv.setOnItemClickListener(new OnItemClickListener() {
    
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) 
        {
               
            String item = ContentList.get(position);  
          
            File targetFile = new File(Path+"/"+item+"/Index.html");
            Uri targetUri = Uri.fromFile(targetFile);
            Intent intent;
            intent = new Intent(Intent.ACTION_VIEW);                        
            intent.setDataAndType(targetUri, "text/html");
            startActivity(intent);                        
             
            
           
    }});
        }
                  }
        
        
    
}
