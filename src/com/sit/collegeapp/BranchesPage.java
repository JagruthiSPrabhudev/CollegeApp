package com.sit.collegeapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BranchesPage extends Activity {
Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_branches_page);
		addListenerOnButton();
	}
		
		
		public void addListenerOnButton() {
			final Context context = this;
			button1 = (Button) findViewById(R.id.button1);
			button1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					 finish();
					 System.exit(0);
				}
			});
	}
		
		
	


}
