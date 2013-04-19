package com.iitb.oscar;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class First extends Activity  {
	ImageButton next;
	TextView link;
	String htmllink;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		htmllink="<u><i>http://oscar.iitb.ac.in</i></u>";
		next=(ImageButton)findViewById(R.id.nextbutton);
		link=(TextView)findViewById(R.id.linktext);
		link.setText(Html.fromHtml(htmllink));
		link.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				 if (event.getAction() == MotionEvent.ACTION_DOWN){
				 Uri targetUri = Uri.parse("http://oscar.iitb.ac.in");
				 Intent intent;
                 intent = new Intent(Intent.ACTION_VIEW);                        
                 intent.setData(targetUri);
             //    intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                 startActivity(intent);             
				// TODO Auto-generated method stub
				
				 }
				 return true;
			}
		});
		
		
		next.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				 if (event.getAction() == MotionEvent.ACTION_DOWN){
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(First.this, Main.class);
			
				startActivity(intent);
				 }
				 return true;
			}
		});
			
			
		
	}

	
	
	

}
