package com.iitb.oscar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class Instruction extends Activity {

	WebView instruction;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instruction);
		
		instruction = (WebView) findViewById(R.id.webView1);
		instruction.getSettings().setJavaScriptEnabled(true);
		
		instruction.loadUrl("file:///android_asset/oscar.html");	
	}



}
